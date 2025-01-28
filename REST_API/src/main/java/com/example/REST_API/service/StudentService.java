package com.example.REST_API.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.REST_API.entity.Student;
import com.example.REST_API.repo.StudentSpringDataJpa;

@Service

public class StudentService {
		
	@Autowired
	private StudentSpringDataJpa studentSpringDataJpa;
	
	public List<Student> fetchData() {
		return studentSpringDataJpa.findAll();
	}	
	
	public void studentAdd(@RequestBody Student stu) {
			
			studentSpringDataJpa.save(stu);
	}	
//	student delete
			public void studentRemove(@PathVariable int id) {
				studentSpringDataJpa.deleteById((long) id);

			}
			// student update
			public void studentUpdate(@PathVariable int id,@RequestBody Student stu ){
				Student student = studentSpringDataJpa.findById((long)id).get();
				student.setAge(stu.getAge());
				student.setBranch(stu.getBranch());
				student.setCourses(stu.getCourses());
				student.setName(stu.getName());
				studentSpringDataJpa.save(stu);
			}
			//find student with specific id
}
