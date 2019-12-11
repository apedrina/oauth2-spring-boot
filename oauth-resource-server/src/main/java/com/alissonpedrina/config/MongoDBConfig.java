package com.alissonpedrina.config;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.alissonpedrina.entity.BuildingEntity;
import com.alissonpedrina.repository.BuildingRepository;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@EnableMongoRepositories(basePackages = "com.alissonpedrina.repository", mongoTemplateRef = "primaryMongoTemplate")
@Configuration
public class MongoDBConfig {

	@Autowired
	private BuildingRepository buildingRepository;

	public void populateDB() throws JsonParseException, JsonMappingException, IOException {
		List<BuildingEntity> lista = new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper();

		List<BuildingEntity> buildings = mapper.readValue(
				Files.readAllBytes(new ClassPathResource("buildings.json").getFile().toPath()),
				new TypeReference<List<BuildingEntity>>() {
				});
		buildingRepository.saveAll(buildings);
	}

}
