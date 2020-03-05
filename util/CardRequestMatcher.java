package com.amt.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

import org.apache.commons.lang3.StringUtils;

import com.amt.model.NIServicesRequest;
import com.github.tomakehurst.wiremock.extension.Parameters;
import com.github.tomakehurst.wiremock.http.Request;
import com.github.tomakehurst.wiremock.matching.MatchResult;
import com.github.tomakehurst.wiremock.matching.RequestMatcherExtension;

public class CardRequestMatcher extends RequestMatcherExtension {

    @Override
    public String getName() {
        return "msg-id-matcher";
    }
    
    com.amt.model.NIServicesRequest niServices;
    
    

    public CardRequestMatcher(NIServicesRequest niServices) {
		super();
		this.niServices = niServices;
	}
    
    
    public CardRequestMatcher(){
    	super();
    }



	@Override
    public MatchResult match(Request request, Parameters parameters) {
    	try{
    		if(request.getUrl().equals("/card")){
				InputStream inputStream = new ByteArrayInputStream(request.getBody());
	
	    		XMLInputFactory xif = XMLInputFactory.newFactory();
	            XMLStreamReader xsr = xif.createXMLStreamReader(inputStream);
	            xsr.nextTag();
	            xsr.nextTag();
	            xsr.nextTag();
	            xsr.nextTag();
	            xsr.nextTag();
	    		
				
				JAXBContext jaxbContext = JAXBContext.newInstance(NIServicesRequest.class);
		    	Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		    	NIServicesRequest ns = (NIServicesRequest)unmarshaller.unmarshal(xsr);
		    	
		    	if(StringUtils.isNotBlank(ns.getBody().getSrvReq().getReqCreditCardBalanceEnquiry().getCardNo())){
		        	return MatchResult.of(true);
		    	}else{
		    		return MatchResult.of(false);
		    	}
	    		
    		} else{
    			return MatchResult.of(false);
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    		return MatchResult.of(false);
    	}
    }
}