package com.example.learn_Jpa_Hybernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component

public class CourseCommandLineRunner implements CommandLineRunner{

	@Autowired
	private CourseJdbcRepository repository;
	@Override
	public void run(String... args) throws Exception {
		repository.insert(new Course(1, "Aarsha", "CSE"));
		repository.insert(new Course(2, "Sonu", "ECE"));
		repository.insert(new Course(3, "Honey", "EEE"));
		repository.deleteById(1);
		
		
		
		
	}

}
