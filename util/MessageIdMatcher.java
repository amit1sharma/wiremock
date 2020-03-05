package com.amt.util;

import com.amt.model.NIServicesRequest;
import com.github.tomakehurst.wiremock.extension.Parameters;
import com.github.tomakehurst.wiremock.http.Request;
import com.github.tomakehurst.wiremock.matching.MatchResult;
import com.github.tomakehurst.wiremock.matching.RequestMatcherExtension;

public class MessageIdMatcher extends RequestMatcherExtension {

    @Override
    public String getName() {
        return "msg-id-matcher";
    }
    
    com.amt.model.NIServicesRequest niServices;
    
    

    public MessageIdMatcher(NIServicesRequest niServices) {
		super();
		this.niServices = niServices;
	}
    
    
    public MessageIdMatcher(){
    	super();
    }



	@Override
    public MatchResult match(Request request, Parameters parameters) {
    	try{
    		if(niServices==null){
    			String body = request.getBodyAsString();
    			System.out.println(body);
    			return MatchResult.of(false);
    		}else{
		        Long messageId = niServices.getHeader().getMsgId();
		        if(messageId!=null){
		        	return MatchResult.of(true);
		        }else{
		        	return MatchResult.of(false);
		        }
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    		return MatchResult.of(false);
    	}
    }
}