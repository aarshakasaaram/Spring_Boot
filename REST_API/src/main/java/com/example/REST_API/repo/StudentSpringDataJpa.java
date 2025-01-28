package com.example.REST_API.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.REST_API.entity.Student;

@Repository
public interface StudentSpringDataJpa extends JpaRepository<Student, Long>{
	
}
