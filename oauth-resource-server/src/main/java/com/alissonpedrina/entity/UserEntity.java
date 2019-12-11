package com.alissonpedrina.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.alissonpedrina.web.dto.User;

@Document("user")
public class UserEntity {

	@Id
	private ObjectId id;

	private String name;

	private String password;

	private String email;

	private boolean isValid;

	private AddressEntity address;

	public UserEntity() {

	}

	public UserEntity(User user) {
		if (user.getId() != null)
			this.id = new ObjectId(user.getId());
		this.name = user.getName();
		this.email = user.getEmail();
		this.isValid = user.isValid();
		this.address = new AddressEntity(user.getAddress());
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}

}
