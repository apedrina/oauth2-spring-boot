package com.alissonpedrina.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import com.alissonpedrina.entity.BuildingEntity;

@Component
public interface BuildingRepository extends MongoRepository<BuildingEntity, String> {

    public BuildingEntity findByName(String name);
    public List<BuildingEntity> findAll();

}