package com.complextable.complex_table.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.complextable.complex_table.entities.Courses;

public interface CoursesRepo extends JpaRepository<Courses, Long>{}
