package com.example.Youtube_RESTAPI.service;




import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Youtube_RESTAPI.entities.Courses;
import com.example.Youtube_RESTAPI.repo.CourseDao;


@Service
public class CourseServiceImp implements CourseService {
	
	
	@Autowired
	private CourseDao courseDao;
	
	
//	List<Courses> list;
	
	public CourseServiceImp() {
		
//		list=new ArrayList<>();
//		list.add(new Courses(145,"Java Core Course", "this course contains basics of java "));
//		list.add(new Courses(146,"Spring Boot Course", "Creating rest api using spring boot "));
	}

	@Override
	public List<Courses> getCourses() {
		
		return courseDao.findAll();
	}
	
	@Override
	public Courses getCourse(long courseId) {
//		Courses c = null;
//		for(Courses course:list) {
//			if(course.getId()==courseId) {
//				c=course;
//				break;
//		}
//	}
		
		return courseDao.getOne(courseId);

	}

	
	@Override
	public Courses addCourse(Courses course) {
//		list.add(course);
		courseDao.save(course);
		return course;
	}

	@Override
	public Courses updateCourse(Courses course) {
//		list.forEach(e -> {
//			if(e.getId()== course.getId()) {
//				e.setTitle(course.getTitle());
//				e.setDescription(course.getDescription());
//			}
//		});
		courseDao.save(course);
		return course;
	}
	
	@Override
	public void deleteCourse(long parseLong) {
//		list = this.list.stream().filter(e ->e.getId()!= parseLong).collect(Collectors.toList());
//	}
		Courses entity = courseDao.getOne(parseLong);
		courseDao.delete(entity);
	
}}
