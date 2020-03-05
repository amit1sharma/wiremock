package com.amt.component;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.tomakehurst.wiremock.WireMockServer;

@Component
public class ConfigureWireMock {
	
	@Autowired
	private WireMockServer wireMockServer;
	

	@PostConstruct
	public void setUpMessageApi(){
		/*wireMockServer.stubFor(post("/message").
				withRequestBody(matchingXPath("/NIServices/header/msg_id"))
				.withHeader("Content-Type", WireMock.equalTo("application/xml"))
    			.willReturn(aResponse()
    	                   .withHeader("Content-Type", "text/xml")
    	                   .withStatus(200)
    	                   .withBodyFile("12345.xml")));*/
		
		
		/*wireMockServer.stubFor(requestMatching(new CardRequestMatcher())
    			.willReturn(aResponse()
    	                   .withHeader("Content-Type", "text/xml")
    	                   .withStatus(200)
    	                   .withTransformers("xmlFileTransformer")));
		*/
		
		/*wireMockServer.stubFor(any(anyUrl())
    			.willReturn(aResponse()
    	                   .withHeader("Content-Type", "text/xml")
    	                   .withStatus(200)
    	                   .withTransformer("xmlFileTransformer","urlEqualTo","all")));*/
	}
	

}
