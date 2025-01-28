package com.example.Employee_Students.students.table;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Students {
	private String name;
	private String branch;
	private String course;
	
	
	@Id
	private int id;
	
	
	public Students() {
		super();
		
	}
	public Students(String name, String branch, String course, int id) {
		super();
		this.name = name;
		this.branch = branch;
		this.course = course;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "StudentsTable [name=" + name + ", branch=" + branch + ", course=" + course + ", id=" + id + "]";
	}
	
	

}
