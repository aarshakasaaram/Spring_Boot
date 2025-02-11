package com.example.restapi.usecase.employee.student.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restapi.usecase.employee.student.project.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long>{

	
}
