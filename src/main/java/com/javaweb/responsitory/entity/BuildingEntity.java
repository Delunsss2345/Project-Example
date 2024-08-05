package com.javaweb.responsitory.entity;

public class BuildingEntity {
	private String name;
	private Integer NumbersOfBasement;
	private String ward;
	private String street ;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getNumbersOfBasement() {
		return NumbersOfBasement;
	}
	public void setNumbersOfBasement(Integer numbers) {
		this.NumbersOfBasement = numbers;
	}
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	
	
}
