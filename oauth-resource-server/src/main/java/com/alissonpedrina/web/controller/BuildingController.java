package com.alissonpedrina.web.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.alissonpedrina.service.BuildingService;
import com.alissonpedrina.web.dto.Building;

@Controller
@RequestMapping(value = "/building")
public class BuildingController {

	@Autowired
	private BuildingService buildingService;

	@Value("classpath:invoice_create.json")
	private Resource invoices;

	public BuildingController() {
		super();
	}

	@PreAuthorize("#oauth2.hasScope('userbuild') and #oauth2.hasScope('read')")
	@RequestMapping(method = RequestMethod.GET, value = "/user/{id}")
	@ResponseBody
	public List<Building> findBuildingByUserId(@PathVariable final long id) {

		List<Building> builds = Arrays.asList(new Building());

		return builds;
	}

	@PreAuthorize("#oauth2.hasScope('userbuild') and #oauth2.hasScope('read')")
	@RequestMapping(method = RequestMethod.GET, value = "/list")
	@ResponseBody
	public List<Building> getAllBuilding() throws IOException {

		return buildingService.getAll().stream().collect(Collectors.toList());

	}

	@PreAuthorize("#oauth2.hasScope('userbuild') and #oauth2.hasScope('write')")
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Building createBuild(@RequestBody final Building building) {

		building.setId(String.valueOf(buildingService.create(building)));

		return building;
	}

	//@PreAuthorize("#oauth2.hasScope('userbuild') and #oauth2.hasScope('write')and hasRole('ROLE_ADMIN')")
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Building updateBuild(@RequestBody final Building build) {

		buildingService.update(build);

		return build;
	}
	
	//@PreAuthorize("#oauth2.hasScope('userbuild') and #oauth2.hasScope('write')and hasRole('ROLE_ADMIN')")
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	@ResponseBody
	public ResponseEntity<String> deleteBuilding(@PathVariable(name = "id") String id){
		
		buildingService.delete(id);
		
		return ResponseEntity.ok().body("");
	}

}
