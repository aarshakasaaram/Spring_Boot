package com.example.restapi.usecase.employee.student.project.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.restapi.usecase.employee.student.project.dto.StudentDto;
import com.example.restapi.usecase.employee.student.project.entity.Student;
import com.example.restapi.usecase.employee.student.project.mapper.StudentMapper;
import com.example.restapi.usecase.employee.student.project.repo.StudentRepo;

@Service
public class StudentService {

	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private StudentMapper studentMapper;
	
	public void studentAdd(@RequestBody Student student)
	{
		studentRepo.save(student);
	}
	
	public List<StudentDto> studentPrint()
	{
		return studentRepo.findAll().stream().map(studentMapper::toStudentDto).collect(Collectors.toList());
	}
	
	public void studentUpdate(@PathVariable int id, @RequestBody Student student)
	{
		Student stu = studentRepo.findById((long)id).get();
		stu.setStudentBranch(student.getStudentBranch());
		stu.setStudentName(student.getStudentName());
		stu.setStudentRollno(student.getStudentRollno());
		studentRepo.save(stu);
	}
	
	
}
