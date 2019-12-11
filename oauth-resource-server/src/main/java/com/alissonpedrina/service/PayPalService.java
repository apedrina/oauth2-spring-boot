package com.alissonpedrina.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PayPalService {
	
	@Autowired
	@Qualifier("payPalRestTemplate")
	private RestTemplate restTemplate;
	
	@Autowired
	private Environment env;
	
	public String findOrderById(String id) {
		return restTemplate.getForEntity(String.format(env.getProperty("paypal.url.checkout.orders"), id), String.class).getBody();
	}


}
