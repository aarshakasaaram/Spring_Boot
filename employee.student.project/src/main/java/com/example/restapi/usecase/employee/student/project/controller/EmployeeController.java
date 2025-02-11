package com.example.restapi.usecase.employee.student.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.usecase.employee.student.project.dto.EmployeeDto;
import com.example.restapi.usecase.employee.student.project.dto.StudentDto;
import com.example.restapi.usecase.employee.student.project.entity.Employee;
import com.example.restapi.usecase.employee.student.project.entity.Student;
import com.example.restapi.usecase.employee.student.project.service.EmployeeService;
import com.example.restapi.usecase.employee.student.project.service.StudentService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("insert")
	public ResponseEntity<EmployeeDto> addEmployee(@RequestBody Employee employee)
	{
		return employeeService.employeeAdd(employee);
	}
	
	@PutMapping("update/{id}")
	public void updateEmployee(@PathVariable int id, @RequestBody Employee employee)
	{
		employeeService.employeeUpdate(id, employee);
	}
	
	@DeleteMapping("delete/{id}")
	public void deleteEmployee(@PathVariable int id)
	{
		employeeService.employeeDelete(id);
	}
	
	@DeleteMapping("delete-name/{name}")
	public ResponseEntity<String> deleteEmployeeByName(@PathVariable String name)
	{
		return employeeService.employeeDeleteByName(name);
	}
	
	@DeleteMapping("delete-desig/{desig}")
	public void deleteEmployeeByDesig(@PathVariable String desig)
	{
		employeeService.employeeDeleteByDesig(desig);
	}
	
	@GetMapping("/display")
	public List<EmployeeDto> printEmployee()
	{
		return employeeService.employeePrint();
	}
	
	@Autowired
	private StudentService stService;
	
	@GetMapping("student-display")
	public List<StudentDto> printStudentByEmployee()
	{
		return stService.studentPrint();
	}
	
	@PostMapping("student-insert")
	public void insertStudentByEmployee(@RequestBody Student student)
	{
		stService.studentAdd(student);
	}
	
	@PutMapping("student-update/{id}")
	public void updateStudentByEmployee(@PathVariable int id, @RequestBody Student student)
	{
		stService.studentUpdate(id, student);
	}
	
}
