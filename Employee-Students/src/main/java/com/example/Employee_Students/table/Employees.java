package com.example.Employee_Students.table;

import jakarta.persistence.Entity;

@Entity

public class Employees {
	
	private String name;
	private String course;
	
	@jakarta.persistence.Id
	private int Id;
	private String branch;
	public Employees() {
		super();
		
	}
	public Employees(String name, String course, int id, String branch) {
		super();
		this.name = name;
		this.course = course;
		Id = id;
		this.branch = branch;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	@Override
	public String toString() {
		return "EmployeeTable [name=" + name + ", course=" + course + ", Id=" + Id + ", branch=" + branch + "]";
	}

}
