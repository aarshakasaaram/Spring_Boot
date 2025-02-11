package com.example.restapi.usecase.employee.student.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.usecase.employee.student.project.dto.StudentDto;
import com.example.restapi.usecase.employee.student.project.entity.Student;
import com.example.restapi.usecase.employee.student.project.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping("insert")
	public void addStudent(@RequestBody Student student){
		studentService.studentAdd(student);
	}
	
	@GetMapping("display")
	public List<StudentDto> printStudent()
	{
		return studentService.studentPrint();
	}
	
}
