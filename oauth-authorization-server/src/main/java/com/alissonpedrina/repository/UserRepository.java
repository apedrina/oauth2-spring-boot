package com.alissonpedrina.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.alissonpedrina.model.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

    public UserEntity findByName(String name);
    public List<UserEntity> findAll();

}