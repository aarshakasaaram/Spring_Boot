package com.example.REST_API.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.REST_API.entity.Student;
import com.example.REST_API.repo.StudentSpringDataJpa;
import com.example.REST_API.service.StudentService;
@RequestMapping
@RestController
public class StudentController
{
	@Autowired
	private StudentSpringDataJpa studentSpringDataJpa;
	@Autowired
	private StudentService studentService;
	
	
	@GetMapping("/display")
	public List<Student> getData() {
		
	return studentService.fetchData();
		
	
	}
	
	@PutMapping("/update/{id}")
	public void updateStudent(@PathVariable int id,@RequestBody Student stu ){
		studentService.studentUpdate(id, stu);
		
		
	}
	@PostMapping("/insert")
	public void addStudent(@RequestBody Student stu) {
		
	     studentService.studentAdd(stu);
	}
	@DeleteMapping("/delete/{id}")
	public void removeStudent(@PathVariable int id) {
		studentService.studentRemove(id);
		
	}
	
		
	
	
	

}
