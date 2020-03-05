package com.amt;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.client.WireMock.verify;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.BeforeClass;
import org.junit.Test;

import com.github.tomakehurst.wiremock.WireMockServer;

public class WebmockTest {

    private static final String BAELDUNG_PATH = "/webmock";

   static private WireMockServer wireMockServer = new WireMockServer(9082);
    private wiremock.org.apache.http.impl.client.CloseableHttpClient httpClient = wiremock.org.apache.http.impl.client.HttpClients.createDefault();

   @BeforeClass
  static public void  start(){
	   wireMockServer.start();
   }
    
    @Test
    public void givenProgrammaticallyManagedServer_whenUsingSimpleStubbing_thenCorrect() throws IOException {
       // wireMockServer.start();

        configureFor("localhost", 9082);
        stubFor(get(urlEqualTo(BAELDUNG_PATH)).willReturn(aResponse().withBody("Welcome to webmock Demo!")));


        wiremock.org.apache.http.client.methods.HttpGet request = new wiremock.org.apache.http.client.methods.HttpGet("http://localhost:9082/webmock");
        wiremock.org.apache.http.HttpResponse httpResponse = httpClient.execute(request);
        String stringResponse = convertResponseToString(httpResponse);

        verify(getRequestedFor(urlEqualTo(BAELDUNG_PATH)));
        assertEquals("Welcome to Baeldung!", stringResponse);

       // wireMockServer.stop();
    }

    private static String convertResponseToString(wiremock.org.apache.http.HttpResponse response) throws IOException {
        InputStream responseStream = response.getEntity().getContent();
        Scanner scanner = new Scanner(responseStream, "UTF-8");
        String stringResponse = scanner.useDelimiter("\\Z").next();
        scanner.close();
        return stringResponse;
    }
}
