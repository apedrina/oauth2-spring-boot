package com.alissonpedrina.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

import com.alissonpedrina.web.interceptor.PayPalInterceptor;

@Configuration
public class PayPalConfig {

	@Autowired
	private Environment env;

	@Autowired
	private PayPalInterceptor tokenInteceptor;
	
	@Bean("payPalRestTemplate")
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getInterceptors().add(tokenInteceptor);
		return restTemplate;
	}

}
