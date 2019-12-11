package com.alissonpedrina.web.dto;

import org.codehaus.jackson.annotate.JsonProperty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthorizationPayPal {

	private String scope;

	private String access_token;
	@JsonProperty(value = "app_id")
	private String appId;
	@JsonProperty(value = "expires_in")
	private String expires_in;
	private String nonce1;

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(String expires_in) {
		this.expires_in = expires_in;
	}

	public String getNonce1() {
		return nonce1;
	}

	public void setNonce1(String nonce) {
		this.nonce1 = nonce;
	}

}
