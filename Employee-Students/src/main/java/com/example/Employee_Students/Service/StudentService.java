package com.example.Employee_Students.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.Employee_Students.students.repo.StudentsRepo;
import com.example.Employee_Students.students.table.Students;


@Service
public class StudentService {
	
	
	@Autowired
	private StudentsRepo studentsRepo;
	
	public List<Students> fetchData() {
		return studentsRepo.findAll();
	}	
	
	public void studentAdd(@RequestBody Students stu) {
			
		studentsRepo.save(stu);
	}
			
			// student update
			public void studentUpdate(@PathVariable int id,@RequestBody Students stu ){
				Students student = studentsRepo.findById((long)id).get();
				student.setId(stu.getId());
				student.setBranch(stu.getBranch());
				student.setCourse(stu.getCourse());
				student.setName(stu.getName());
				studentsRepo.save(stu);
			}

}
