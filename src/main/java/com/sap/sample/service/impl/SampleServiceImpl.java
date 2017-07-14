/**
 * 
 */
package com.sap.sample.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sap.sample.service.SampleService;

@Component
public class SampleServiceImpl implements SampleService {
	private static final Logger LOGGER = LoggerFactory.getLogger(SampleServiceImpl.class);

	@Override
	public Response checkConnection(String urlToCheck) {
		try {
			if (null == urlToCheck) {
				throw new Exception("Please send the URL in the request parameter \'urlToCheck\'");
			}
			LOGGER.info("Checking response from the URL:" + urlToCheck);

			return constructResponse(fetchUrlResponse(urlToCheck), Response.ok());
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return constructResponse(e.getMessage(), Response.serverError());
		}
	}

	private String fetchUrlResponse(String urlUnderTest) throws IOException {
		StringBuilder textView = new StringBuilder();
		try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
			HttpGet httpGet = new HttpGet(urlUnderTest);
			try (CloseableHttpResponse response = httpclient.execute(httpGet)) {
				HttpEntity entity = response.getEntity();
				try (BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()))) {
					String line = "";
					while ((line = rd.readLine()) != null) {
						textView.append(line);
					}
				}
				EntityUtils.consume(entity);
			}
		} catch (IOException e) {
			textView.append(e.getMessage());
			throw e;
		}
		return textView.toString();
	}

	private Response constructResponse(String fetchUrlResponse, ResponseBuilder responseBuilder) {
		responseBuilder.entity(fetchUrlResponse);
		return responseBuilder.build();
	}

}
