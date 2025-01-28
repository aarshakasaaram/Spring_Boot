package com.example.Employee_Students.employeescontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Employee_Students.employeesservice.EmployeesService;

import com.example.Employee_Students.table.Employees;
@RestController
public class EmployeesController {
	
		
		@Autowired
		private EmployeesService employeesService;

		
		@GetMapping("/employee/display")
		public List<Employees> getData() {
			
		return employeesService.fetchData();
			
		
		}
		@PostMapping("/employee/insert")
		public void addEmployee(@RequestBody Employees emp) {
			
		     employeesService.employeeAdd(emp);
		
			

	}   
		
		@PutMapping("/employee/update/{Id}")
		public void updateEmployee(@PathVariable int Id, @RequestBody Employees emp) {
			
			employeesService.employeeUpdate(Id, emp);
			
		}
		}


