package com.example.restapi.usecase.employee.student.project.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.restapi.usecase.employee.student.project.dto.EmployeeDto;
import com.example.restapi.usecase.employee.student.project.entity.Employee;
import com.example.restapi.usecase.employee.student.project.mapper.EmployeeMapper;
import com.example.restapi.usecase.employee.student.project.repo.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	public ResponseEntity<EmployeeDto>  employeeAdd(Employee employee)
	{
		 // Save the employee to the repository
        Employee savedEmployee = employeeRepo.save(employee);

        // Convert saved employee to EmployeeDto
        EmployeeDto employeeDto = employeeMapper.toEmployeeDto(savedEmployee);

        // Return ResponseEntity with a 201 Created status and the employeeDto in the body
        return new ResponseEntity<>(employeeDto, HttpStatus.CREATED);
		
	}
	
	public void employeeUpdate(int id, Employee employee)
	{
		Employee emp = employeeRepo.findById((long)id).get();
		emp.setEmployeeName(employee.getEmployeeName());
		emp.setEmployeeDesig(employee.getEmployeeDesig());
		employeeRepo.save(emp);
		
	}   
	
	public ResponseEntity<String> employeeDeleteByName(String name) {
	    try {
	        Optional<Employee> emp = employeeRepo.findByName(name);

	        if (emp.isPresent()) {
	            employeeRepo.deleteByName(name);
	            return ResponseEntity.ok("Employee with name '" + name + "' deleted successfully.");
	        } else {
	            return ResponseEntity.status(404).body("Employee with name '" + name + "' not found.");
	        }
	    } catch (Exception e) {
	        return ResponseEntity.status(500).body("An error occurred: " + e.getMessage());
	    }
	}
	
	public void employeeDeleteByDesig(String desig)
	{
		employeeRepo.deleteByDesig(desig);
	}
	
	public void employeeDelete(int id){
		Employee emp = employeeRepo.findById((long)id).get();
		if (emp == null)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		else
		{
			employeeRepo.deleteById((long)id);	
		}
	}
	
	public List<EmployeeDto> employeePrint()
	{
		return employeeRepo.findAll().stream().map(employeeMapper::toEmployeeDto).collect(Collectors.toList());
	}
	
}
