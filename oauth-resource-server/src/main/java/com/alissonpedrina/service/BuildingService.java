package com.alissonpedrina.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alissonpedrina.entity.BuildingEntity;
import com.alissonpedrina.repository.BuildingRepository;
import com.alissonpedrina.web.dto.Building;

@Component
public class BuildingService {

	@Autowired
	private BuildingRepository buildingRepository;

	public void update(Building building) {
		BuildingEntity entity = new BuildingEntity(building);
		buildingRepository.save(entity);
	}

	public String create(Building building) {
		BuildingEntity entity = new BuildingEntity(building);
		buildingRepository.insert(entity);

		return String.valueOf(entity.getId());
	}

	public List<Building> getAll() {

		List<BuildingEntity> entities = buildingRepository.findAll();
		return entities.stream().map(e -> new Building(e)).collect(Collectors.toList());

	}

	public List<BuildingEntity> create(List<BuildingEntity> buildings) {
		return buildingRepository.saveAll(buildings);
	}

	public void delete(String id) {
		buildingRepository.deleteById(id);
	}

}
