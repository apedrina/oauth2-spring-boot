package com.alissonpedrina.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.alissonpedrina.entity.UserEntity;

public interface UserRepository extends MongoRepository<UserEntity, String> {

    public UserEntity findByName(String name);
    public List<UserEntity> findAll();

}