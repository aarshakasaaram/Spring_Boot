package com.example.springboot_RESTAPI.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Posts {
	
	@Id
	private int id;
	private String description;
	
	public Posts(int id, String description) {
		super();
		this.id = id;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Posts [id=" + id + ", description=" + description + "]";
	}

	
	
	
}
