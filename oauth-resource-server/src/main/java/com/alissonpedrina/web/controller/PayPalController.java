package com.alissonpedrina.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestTemplate;

import com.alissonpedrina.service.PayPalService;
import com.alissonpedrina.web.dto.PayPalTransaction;

@Controller
@RequestMapping("/paypal")
public class PayPalController {
	
	@Autowired
	private PayPalService payPalService;

	@Autowired
	@Qualifier("payPalRestTemplate")
	private RestTemplate restTemplate;

	public PayPalController() {
		super();
	}

	//@PreAuthorize("#oauth2.hasScope('userbuild') and #oauth2.hasScope('read')")
	@RequestMapping(method = RequestMethod.GET, value = "/user/{id}")
	@ResponseBody
	public PayPalTransaction findTransactionByUserId(@PathVariable final long id) {

		return new PayPalTransaction();
	}

	//@PreAuthorize("#oauth2.hasScope('userbuild') and #oauth2.hasScope('read')")
	@RequestMapping(method = RequestMethod.GET, value = "/orders/{id}")
	@ResponseBody
	public String getOrderById(@PathVariable String id) {

		return payPalService.findOrderById(id);

	}

	//@PreAuthorize("#oauth2.hasScope('userbuild') and #oauth2.hasScope('write') and hasRole('ROLE_ADMIN')")
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public PayPalTransaction createTransaction(@RequestBody final PayPalTransaction transaction) {
		return null;
	}

}
