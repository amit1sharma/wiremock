package com.amt.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amt.config.MockServiceInitializer;
import com.amt.testmodel.NIService;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;

import wiremock.org.apache.http.HttpResponse;
import wiremock.org.apache.http.client.ClientProtocolException;
import wiremock.org.apache.http.client.methods.HttpGet;
import wiremock.org.apache.http.impl.client.CloseableHttpClient;
import wiremock.org.apache.http.impl.client.HttpClients;

@RestController
public class MessageDetailsController {
	
	
	@Autowired
	private WireMockServer wireMockServer;
	
	@Value("${wmServerUrl}")
	private String wmServerUrl;
	

    @RequestMapping(value="/messageDetail",method=RequestMethod.POST, consumes="application/xml", produces="text/xml")  
    public NIService messageStub(@RequestBody NIService niServicesRequest) throws ClientProtocolException, IOException{
    	try{
    		System.out.println("received request");
    		
	    	wireMockServer.stubFor(WireMock.get(WireMock.urlPathMatching("/messageDetail"))
	    			.withQueryParam("msg_id", WireMock.equalTo(niServicesRequest.getHeader().getMsg_id()+""))
	    			.willReturn(WireMock.aResponse()
//	    	                   .withHeader("Content-Type", "text/xml")
	    	                   .withBodyFile(niServicesRequest.getHeader().getMsg_id()+".xml")));
	    	System.out.println("Configured wiremock");
	    	
	    	CloseableHttpClient httpClient = HttpClients.createDefault();
	    	HttpGet request = new HttpGet(wmServerUrl+":"+MockServiceInitializer.mockServerPort+"/messageDetail?msg_id="+niServicesRequest.getHeader().getMsg_id());
	    	HttpResponse httpResponse = httpClient.execute(request);
//	    	String stringResponse = convertHttpResponseToString(httpResponse);
	    	
	    	
	    	System.out.println("called wm api");
	    	
	    	JAXBContext jaxbContext = JAXBContext.newInstance(NIService.class);
	    	Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();	
	    	NIService niServicesResponse = (NIService)unmarshaller.unmarshal(httpResponse.getEntity().getContent());
	    	System.out.println("converted string to object");
	    	return niServicesResponse;
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
        return new NIService();
    }
    
    @RequestMapping(value="/",method=RequestMethod.POST, consumes="text/html", produces="text/html")
    public ResponseEntity creditCardStub(@RequestBody String requestString) throws ClientProtocolException, IOException{
//    public ResponseEntity creditCardStub(@RequestBody NIService niServicesRequest) throws ClientProtocolException, IOException{
    	try{
    		System.out.println("thisd is request"+ requestString);
    		InputStream stream = new ByteArrayInputStream(requestString.getBytes(StandardCharsets.UTF_8));

    		JAXBContext jaxbContext = JAXBContext.newInstance(NIService.class);
	    	Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();	
	    	NIService niServicesRequest = (NIService)unmarshaller.unmarshal(stream);
	    	
    		String ccNo = niServicesRequest.getBody().getSrvReq().getReqCreditCardBalanceEnquiry().getCardNo();
    		System.out.println("received request");
	    	wireMockServer.stubFor(WireMock.get(WireMock.urlPathMatching("/ccDetails"))
	    			.withQueryParam("card_no", WireMock.equalTo(ccNo))
	    			.willReturn(WireMock.aResponse()
//	    	                   .withHeader("Content-Type", "text/xml")
	    	                   .withBodyFile(ccNo+".xml")));
	    	System.out.println("Configured wiremock");
	    	
	    	CloseableHttpClient httpClient = HttpClients.createDefault();
	    	HttpGet request = new HttpGet(wmServerUrl+":"+MockServiceInitializer.mockServerPort+"/ccDetails?card_no="+ccNo);
	    	HttpResponse httpResponse = httpClient.execute(request);
//	    	String stringResponse = convertHttpResponseToString(httpResponse);
	    	
	    	System.out.println("called wm api");
	    	String response = convertHttpResponseToString(httpResponse);
	    	
	    	HttpHeaders responseHeaders = new HttpHeaders();
	        responseHeaders.set("Content-Type","text/html; charset=UTF-8");
	    	return ResponseEntity.ok()
	    		      .headers(responseHeaders)
	    		      .body(response);
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    	HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type","text/html; charset=UTF-8");
    	return ResponseEntity.ok()
    		      .headers(responseHeaders).build();
    }
    
    
    private String convertHttpResponseToString(HttpResponse httpResponse) throws IOException {
        InputStream inputStream = httpResponse.getEntity().getContent();
        return convertInputStreamToString(inputStream);
    }
    private String convertInputStreamToString(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream, "UTF-8");
        String string = scanner.useDelimiter("\\Z").next();
        scanner.close();
        return string;
    }
    
    @Value("${filesPath}")
    private String filesPath;
    
    
    @RequestMapping("/config")
	public String welcome() {
		return "welcome file path is : "+filesPath+"\n server url = "+wmServerUrl;
	}
}  