package com.example.Employee_Students.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Employee_Students.table.Employees;

public interface EmployeeRepo extends JpaRepository<Employees, Long> {

}
