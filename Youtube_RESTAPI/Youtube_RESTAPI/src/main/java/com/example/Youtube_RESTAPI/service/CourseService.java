package com.example.Youtube_RESTAPI.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Youtube_RESTAPI.entities.Courses;
@Service
public interface CourseService {
	
	
public List<Courses> getCourses();

public Courses getCourse(long courseId);

public Courses addCourse(Courses course);

public Courses updateCourse(Courses course);

public void deleteCourse(long courseId);

}
