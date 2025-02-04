package com.example.Employee_Students.students.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Employee_Students.students.table.Students;

public interface StudentsRepo extends JpaRepository<Students, Long> {

}
