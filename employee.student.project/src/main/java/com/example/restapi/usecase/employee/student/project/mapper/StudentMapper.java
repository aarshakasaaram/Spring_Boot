package com.example.restapi.usecase.employee.student.project.mapper;

import org.springframework.stereotype.Component;

import com.example.restapi.usecase.employee.student.project.dto.StudentDto;
import com.example.restapi.usecase.employee.student.project.entity.Student;

@Component
public class StudentMapper {

	public StudentDto toStudentDto(Student student)
	{
		if (student == null)
		{
			return null;
		}
		return new StudentDto(
				student.getStudentId(),
				student.getStudentName(),
				student.getStudentBranch(),
				student.getStudentRollno()
			);
	}
	
}