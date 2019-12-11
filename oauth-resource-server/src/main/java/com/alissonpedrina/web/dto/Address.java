package com.alissonpedrina.web.dto;

import com.alissonpedrina.entity.AddressEntity;

public class Address {

	private String id;

	private String street;

	private String type;

	public Address() {
	}

	public Address(AddressEntity address) {
		if (address.getId() != null)
			this.id = address.getId().toHexString();
		this.street = address.getStreet();
		this.type = address.getType();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
