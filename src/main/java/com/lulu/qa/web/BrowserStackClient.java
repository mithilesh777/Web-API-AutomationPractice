package com.lulu.qa.web;

import java.io.IOException;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lulu.qa.web.pages.AbstractGoodRxPage;

public class BrowserStackClient {

	private String userName;

	private String accessKey;

	private static final String URL = "https://api.browserstack.com/automate/sessions/";
	private static final String URL_APP = "https://api-cloud.browserstack.com/app-automate/sessions/";

	public BrowserStackClient(String userName, String accessKey) {
		this.userName = userName;
		this.accessKey = accessKey;
	}

	/**
	 * Update test execution result
	 * 
	 * @param sessionId
	 * @param statusData
	 * @return
	 * @throws IOException
	 */
	public String updateSessionStatus(String sessionId, Map<String, String> statusData) throws IOException {

		HttpPut request;
		if ("android".equalsIgnoreCase(AbstractGoodRxPage.getTargetClient())) {
			request = new HttpPut(URL_APP + sessionId + ".json");
		} else {
			request = new HttpPut(URL + sessionId + ".json");
		}

		CredentialsProvider provider = new BasicCredentialsProvider();
		provider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(this.userName, this.accessKey));

		// add request headers
		request.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
		ObjectMapper mapper = new ObjectMapper();
		String status = mapper.writeValueAsString(statusData);
		request.setEntity(new StringEntity(status));

		try (CloseableHttpClient httpClient = HttpClientBuilder.create().setDefaultCredentialsProvider(provider)
				.build(); CloseableHttpResponse response = httpClient.execute(request)) {

			HttpEntity entity = response.getEntity();
			if (entity != null) {
				// return it as a String
				return EntityUtils.toString(entity);
			}
		}
		return null;
	}
}
