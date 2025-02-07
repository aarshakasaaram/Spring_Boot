package com.complextable.complex_table.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.complextable.complex_table.entities.Department;

public interface DepartmentRepo extends JpaRepository<Department, Long>{}