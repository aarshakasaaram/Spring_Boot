package com.example.Youtube_RESTAPI.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Youtube_RESTAPI.entities.Courses;

public interface CourseDao extends JpaRepository<Courses, Long> {

}
