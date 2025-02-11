package com.example.restapi.usecase.employee.student.project.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
	
	@Id
	private long employeeIdDto;
	
	private String employeeNameDto;
	
	private String employeeDesigDto;	

	
}
