package com.example.restapi.usecase.employee.student.project.mapper;

import org.springframework.stereotype.Component;

import com.example.restapi.usecase.employee.student.project.dto.EmployeeDto;
import com.example.restapi.usecase.employee.student.project.entity.Employee;


@Component
public class EmployeeMapper {

	public EmployeeDto toEmployeeDto(Employee employee)
	{
		if (employee == null)
		{
			return null;
		}
		return new EmployeeDto(
				employee.getEmployeeId(),
				employee.getEmployeeName(),
				employee.getEmployeeDesig()
			);
	}
	
}
