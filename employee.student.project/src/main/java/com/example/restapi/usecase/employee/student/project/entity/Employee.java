package com.example.restapi.usecase.employee.student.project.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Employee")
public class Employee {

	@Id
	@Column(name = "employee_id")
	private long employeeId;
	
	@Column(name = "employee_name")
	private String employeeName;
	
	@Column(name = "employee_desig")
	private String employeeDesig;	

}
