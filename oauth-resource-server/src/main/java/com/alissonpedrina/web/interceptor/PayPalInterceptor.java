package com.alissonpedrina.web.interceptor;

import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.alissonpedrina.web.dto.AuthorizationPayPal;

@Component
public class PayPalInterceptor implements ClientHttpRequestInterceptor {

	@Autowired
	private Environment env;

	private static String token;

	private static long VALID_TIME_TOKEN;

	private RestTemplate restTemplate;

	public PayPalInterceptor() {
		this.restTemplate = new RestTemplate();
	}

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {

		if (new Date().getTime() > VALID_TIME_TOKEN) {
			request.getHeaders().setBearerAuth(getToken());
		} else {
			request.getHeaders().setBearerAuth(token);
		}

		request.getHeaders().setBasicAuth(env.getProperty("paypal.clientID"), env.getProperty("paypal.clientSecret"));
		request.getHeaders().setContentType(MediaType.APPLICATION_JSON);

		return execution.execute(request, body);

	}

	private String getToken() {

		var headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.setBasicAuth(env.getProperty("paypal.clientID"), env.getProperty("paypal.clientSecret"));

		var map = new LinkedMultiValueMap<String, String>();
		map.add("grant_type", "client_credentials");

		var request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

		var response = restTemplate.postForEntity(env.getProperty("paypal.url.gettoken"), request,
				AuthorizationPayPal.class);

		VALID_TIME_TOKEN = new Date().getTime() + Long.valueOf(response.getBody().getExpires_in());
		token = response.getBody().getAccess_token();

		return token;
	}

}
