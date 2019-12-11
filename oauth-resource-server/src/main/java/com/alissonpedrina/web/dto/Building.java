package com.alissonpedrina.web.dto;

import java.util.List;

import com.alissonpedrina.entity.BuildingEntity;

public class Building {
	private String id;
	private long ownerId;
	private String name;
	private List<Double[]> coords;
	private int floors;
	private Double floorHeight;
	private Double height;

	public Building() {
		super();
	}

	public Building(final String id, final String name) {
		super();

		this.id = id;
		this.name = name;
	}

	public Building(BuildingEntity building) {
		if (building.getId() != null)
			this.id = building.getId().toHexString();
		this.name = building.getName();
		this.ownerId = building.getOwnerId();
		this.coords = building.getCoords();
		this.floorHeight = building.getFloorHeight();
		this.floors = building.getFloors();
		this.height = building.getHeight();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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