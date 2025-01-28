package com.example.Employee_Students.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Employee_Students.Service.StudentService;
import com.example.Employee_Students.students.table.Students;

@RestController
public class StudentsController {
	
	@Autowired
	private StudentService studentService;

	
	@GetMapping("/display")
	public List<Students> getData() {
		
	return studentService.fetchData();
		
	
	
	
	
		
	}
	@PostMapping("/insert")
	public void addStudent(@RequestBody Students stu) {
		
	     studentService.studentAdd(stu);
	
		

}}
