package com.amt.controllers;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import wiremock.org.apache.http.HttpResponse;
import wiremock.org.apache.http.client.methods.HttpGet;
import wiremock.org.apache.http.impl.client.CloseableHttpClient;
import wiremock.org.apache.http.impl.client.HttpClients;

import com.amt.config.MockServiceInitializer;
import com.amt.model.NIServicesRequest;
import com.amt.model.NIServicesResponse;
import com.amt.testmodel.NIService;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;

@Endpoint
public class CCDetailsEndpoint {
	
//	@Value("${mock.server.port}")
//	private int mockServerPort=9080;
	
	@Autowired
	private WireMockServer wireMockServer;
	
	@Value("${wmServerUrl}")
	private String wmServerUrl;

	@PayloadRoot(namespace = "http://adcb.com/poc/wiremock", localPart = "NIServices")
	@ResponsePayload
	public NIServicesResponse processCardDetailsRequest(@RequestPayload NIServicesRequest niServicesRequest) {
		try{
			String ccNo = niServicesRequest.getBody().getSrvReq().getReqCreditCardBalanceEnquiry().getCardNo();
    		System.out.println("received request");
	    	wireMockServer.stubFor(WireMock.get(WireMock.urlPathMatching("/ccDetails"))
	    			.withQueryParam("card_no", WireMock.equalTo(ccNo))
	    			.willReturn(WireMock.aResponse()
	    	                   .withBodyFile(ccNo+".xml")));
	    	System.out.println("Configured wiremock");
	    	
	    	CloseableHttpClient httpClient = HttpClients.createDefault();
	    	HttpGet request = new HttpGet(wmServerUrl+":"+MockServiceInitializer.mockServerPort+"/ccDetails?card_no="+ccNo);
	    	HttpResponse httpResponse = httpClient.execute(request);
	    	
	    	JAXBContext jaxbContext = JAXBContext.newInstance(NIService.class);
	    	Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
	    	NIService ns = (NIService)unmarshaller.unmarshal(httpResponse.getEntity().getContent());
	    	NIServicesResponse nsr = new NIServicesResponse();
	    	nsr.setBody(ns.getBody());
	    	nsr.setHeader(ns.getHeader());
	    	
	    	return nsr;
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
		catch(Throwable th){
			th.printStackTrace();
		}
        return new NIServicesResponse();
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

}