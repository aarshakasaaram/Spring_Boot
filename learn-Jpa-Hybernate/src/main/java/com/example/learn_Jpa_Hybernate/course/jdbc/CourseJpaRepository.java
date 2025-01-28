package com.example.learn_Jpa_Hybernate.course.jdbc;


import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository

public class CourseJpaRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
public void insert(Course course) {
	entityManager.merge(course);
}
public Course findById(long id) {
	return entityManager.find(Course.class, id);
	
}
public void deleteById(long id) {
	Course course = entityManager.find(Course.class, id);

	
	entityManager.remove(course);
}
	
}
