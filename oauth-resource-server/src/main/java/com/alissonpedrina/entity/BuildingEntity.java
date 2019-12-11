package com.alissonpedrina.entity;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.alissonpedrina.web.dto.Building;

@Document("building")
public class BuildingEntity {
	
	@Transient
    public static final String SEQUENCE_NAME = "users_sequence";

	@Id
	private ObjectId id;
	private long ownerId;
	private String name;
	private List<Double[]> coords;
	private int floors;
	private Double floorHeight;
	private Double height;

	public BuildingEntity() {
		super();
	}

	public BuildingEntity(final String id, final String name) {
		super();

		this.id = new ObjectId(id);
		this.name = name;
	}

	public BuildingEntity(Building building) {

		if (building.getId() != null)
			this.id = new ObjectId(building.getId());
		this.name = building.getName();
		this.ownerId = building.getOwnerId();
		this.coords = building.getCoords();
		this.floorHeight = building.getFloorHeight();
		this.floors = building.getFloors();
		this.height = building.getHeight();

	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId;
	}

	public List<Double[]> getCoords() {
		return coords;
	}

	public void setCoords(List<Double[]> coords) {
		this.coords = coords;
	}

	public int getFloors() {
		return floors;
	}

	public void setFloors(int floors) {
		this.floors = floors;
	}

	public Double getFloorHeight() {
		return floorHeight;
	}

	public void setFloorHeight(Double floorHeight) {
		this.floorHeight = floorHeight;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

}