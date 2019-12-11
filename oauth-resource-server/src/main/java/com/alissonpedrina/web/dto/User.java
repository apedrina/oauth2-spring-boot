package com.alissonpedrina.web.dto;

import com.alissonpedrina.entity.UserEntity;

public class User {

	private String id;

	private String name;

	private String email;

	private boolean isValid;

	private Address address;
	
	public User() {
		
	}

	public User(UserEntity entity) {
		this.id = entity.getId().toHexString();
		this.name = entity.getName();
		this.email = entity.getEmail();
		this.isValid = entity.isValid();
		this.address = new Address(entity.getAddress());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
