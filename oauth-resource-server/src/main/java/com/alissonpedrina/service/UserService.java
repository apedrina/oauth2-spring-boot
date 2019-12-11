package com.alissonpedrina.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alissonpedrina.entity.UserEntity;
import com.alissonpedrina.repository.UserRepository;
import com.alissonpedrina.web.dto.User;

@Component
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public void update(User building) {
		UserEntity entity = new UserEntity(building);
		userRepository.save(entity);
	}

	public String create(User user) {
		UserEntity entity = new UserEntity(user);
		userRepository.insert(entity);

		return String.valueOf(entity.getId());
	}

	public List<User> getAll() {

		List<UserEntity> entities = userRepository.findAll();
		return entities.stream().map(e -> new User(e)).collect(Collectors.toList());

	}

}
