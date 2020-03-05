package com.amt.config;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amt.util.XmlFileTransformer;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.Options;


@Configuration
public class MockServiceInitializer {
	
	/*@Value("${mock.server.port}")
	private int mockServerPort;*/
	
	@Value("${filesPath}")
	private String filesPath;
	
	@Value("${wmServerUrl}")
	private String wmServerUrl;
	
	public static final int mockServerPort = 9123;
	
	@Bean
	public WireMockServer wireMockServer (){
		System.out.println("response xml file path : "+filesPath);
		Options options = options().port(mockServerPort)
//				.bindAddress(wmServerUrl)
				.extensions(XmlFileTransformer.class)
		.usingFilesUnderDirectory(filesPath);
		WireMockServer wms = new WireMockServer(options);
		wms.start();
		return wms;

	}
	
	
}
