package com.example.REST_API.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class Student {
	@Id
	private long id;
	
	private String name;
	private String Branch;
	private int age;
	private String courses;
	public Student() {
		super();
		
		
	}
	public Student(long id, String name, String branch, int age, String courses) {
		super();
		this.id = id;
		this.name = name;
		Branch = branch;
		this.age = age;
		this.courses = courses;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBranch() {
		return Branch;
	}
	public void setBranch(String branch) {
		Branch = branch;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCourses() {
		return courses;
	}
	public void setCourses(String courses) {
		this.courses = courses;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", Branch=" + Branch + ", age=" + age + ", courses=" + courses
				+ "]";
	}
	
	
	

}
