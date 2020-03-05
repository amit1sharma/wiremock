package com.amt.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;

import com.amt.testmodel.NIService;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.common.FileSource;
import com.github.tomakehurst.wiremock.extension.Parameters;
import com.github.tomakehurst.wiremock.extension.ResponseDefinitionTransformer;
import com.github.tomakehurst.wiremock.http.Request;
import com.github.tomakehurst.wiremock.http.ResponseDefinition;

public class XmlFileTransformer extends ResponseDefinitionTransformer {

        @Override
        public ResponseDefinition transform(Request request, ResponseDefinition responseDefinition, FileSource files, Parameters parameters) {
        	String parameter1 = parameters!=null?parameters.getString("urlEqualTo"):null;
        	if(parameter1!=null && parameter1.equals("all") || request.getUrl().equals(parameter1)){
	        	InputStream inputStream = new ByteArrayInputStream(request.getBody());
	
	    		/*XMLInputFactory xif = XMLInputFactory.newFactory();
	            XMLStreamReader xsr;*/
				try {
					/*xsr = xif.createXMLStreamReader(inputStream);
					xsr.nextTag();
		            xsr.nextTag();
		            xsr.nextTag();
		            xsr.nextTag();
		            xsr.nextTag();*/
				
					JAXBContext jaxbContext = JAXBContext.newInstance(NIService.class);
			    	javax.xml.bind.Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			    	NIService ns = (NIService)unmarshaller.unmarshal(inputStream);
		        	
		            return new ResponseDefinitionBuilder()
		            		.withHeader("Content-Type", "text/xml")
		                    .withStatus(200)
		                    .withBodyFile(ns.getBody().getSrvReq().getReqCreditCardBalanceEnquiry().getCardNo()+".xml")
		                    .build();
				} catch (Exception e) {
					e.printStackTrace();
					return new ResponseDefinitionBuilder()
							.withHeader("Content-Type", "text/xml")
			                   .withStatus(200)
			                   .withBody("<body>"+e.getMessage()+"</body>")
			                   .build();
				}
			}else{
				return responseDefinition;
			}
        }

        @Override
        public String getName() {
            return "xmlFileTransformer";
        }
    }