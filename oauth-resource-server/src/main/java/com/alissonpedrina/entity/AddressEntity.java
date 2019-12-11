package com.alissonpedrina.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import com.alissonpedrina.web.dto.Address;

public class AddressEntity {

	@Id
	private ObjectId id;

	private String street;

	private String type;
	
	public AddressEntity() {
		
	}

	public AddressEntity(Address address) {
		if (address.getId() != null)
			this.id = new ObjectId(address.getId());
		this.street = address.getStreet();
		this.type = address.getType();
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
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
