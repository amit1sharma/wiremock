package com.amt.config;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.Wsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter{

	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
		MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
		messageDispatcherServlet.setApplicationContext(context);
		messageDispatcherServlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(messageDispatcherServlet, "/ws/*");
	}

	/*@Bean(name = "message")
	public DefaultWsdl11Definition messageWsdl11Definition(XsdSchema messageSchema) {
		DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
		definition.setPortTypeName("messagePort");
		definition.setTargetNamespace("http://adcb.com/poc/wiremock/messagedetails");
		definition.setLocationUri("/ws");
		definition.setSchema(messageSchema);
		return definition;
	}

	@Bean(name="messageSchema")
	public XsdSchema messageSchema() {
		return new SimpleXsdSchema(new ClassPathResource("xsds/message-details.xsd"));
	}
	*/
	@Bean(name = "card")
	public Wsdl11Definition cardWsdl11Definition(XsdSchema cardSchema) {
		
		SimpleWsdl11Definition wsdl11Definition = new SimpleWsdl11Definition();
        wsdl11Definition.setWsdl(new ClassPathResource("wsdl/card-detail.wsdl"));
        return wsdl11Definition;
	}

	@Bean(name="cardSchema")
	public XsdSchema cardSchema() {
		return new SimpleXsdSchema(new ClassPathResource("xsds/card-details.xsd"));
	}
}