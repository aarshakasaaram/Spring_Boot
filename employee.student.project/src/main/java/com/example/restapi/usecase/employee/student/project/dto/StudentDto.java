package com.example.restapi.usecase.employee.student.project.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

	@Id
	private long studentIdDto;
	
	private String studentNameDto;
	
	private String studentBranchDto;
	
	private long studentRollnoDto;
	
}
