package com.example.Employee_Students.employeesservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.Employee_Students.repo.EmployeeRepo;

import com.example.Employee_Students.table.Employees;


@Service
public class EmployeesService {
	@Autowired
	private EmployeeRepo employeesRepo;
	
	public List<Employees> fetchData() {
		return employeesRepo.findAll();
	}	
	
	public void employeeAdd(@RequestBody Employees emp) {
			
		employeesRepo.save(emp);
	}
			
			// student update
			public void employeeUpdate(@PathVariable int id,@RequestBody Employees emp ){
				Employees employe = employeesRepo.findById((long)id).get();
				employe.setId(emp.getId());
				employe.setBranch(emp.getBranch());
				employe.setCourse(emp.getCourse());
				employe.setName(emp.getName());
				employeesRepo.save(employe);
			}


}
