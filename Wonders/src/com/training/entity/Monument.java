package com.training.entity;

import org.springframework.stereotype.Component;

@Component
public class Monument {

	private String name;
	private String description;
	private String continent;
	private String type;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Monument [name=" + name + ", description=" + description + ", continent="
				+ continent + ", type=" + type + "]";
	}
	public Monument(String name, String description, String continent, String type) {
		super();
		this.name = name;
		this.description = description;
		this.continent = continent;
		this.type = type;
	}
	public Monument() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
