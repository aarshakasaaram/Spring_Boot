package com.onetoonemapping.one_to_one_mapping.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onetoonemapping.one_to_one_mapping.entities.Idcard;
import com.onetoonemapping.one_to_one_mapping.entities.Student;
import com.onetoonemapping.one_to_one_mapping.repo.IdcardRepo;
import com.onetoonemapping.one_to_one_mapping.repo.StudentRepo;



@Service
public class StudentService {
	
	   @Autowired
		private StudentRepo stuRepo;
		
		@Autowired
		private IdcardRepo idRepo;
		
		public Student createStu(Student stu) {
			if (stu.getIdCard() != null && stu.getIdCard().getCardid() != 0) {
	            Optional<Idcard> idCardOpt = idRepo.findById(stu.getIdCard().getCardid());

	            if (idCardOpt.isPresent()) {
	                // If the Idcard exists, link it to the student
	                stu.setIdCard(idCardOpt.get());
	            } else {
	                // If the Idcard doesn't exist, you can throw an exception or handle it
	                throw new RuntimeException("ID card not found with ID: " + stu.getIdCard().getCardid());
	            }
	        }
	        return stuRepo.save(stu);
	    }
	 
	    public List<Student> getAllStudents() {
	        return stuRepo.findAll();
	    }

	    public Student getStudentById(Long id) {
	        return stuRepo.findById(id).orElse(null);
	    }

	    public Student updateStudent(Long id, Student updatedStudent) {
	        Optional<Student> existingStudentOpt = stuRepo.findById(id);

	        if (existingStudentOpt.isPresent()) {
	            Student existingStudent = existingStudentOpt.get();
	            existingStudent.setStuname(updatedStudent.getStuname());
	            existingStudent.setStuemail(updatedStudent.getStuemail());
	            existingStudent.setPhone(updatedStudent.getPhone());

	            if (updatedStudent.getIdCard() != null) {
	                existingStudent.setIdCard(updatedStudent.getIdCard());
	            }

	            return stuRepo.save(existingStudent);
	        } else {
	            throw new RuntimeException("Student not found with ID: " + id);
	        }
	    }

	    @Transactional
	    public void deleteStudent(Long id) {
	        Optional<Student> stud = stuRepo.findById(id);
	        if (stud.isPresent()) {
	            Student stu = stud.get();

	            if (stu.getIdCard() != null) {
	                idRepo.delete(stu.getIdCard());  
	                stu.setIdCard(null);
	            }

	            stuRepo.delete(stu);
	        } else {
	            throw new RuntimeException("Student not found with ID: " + id);
	        }
	    }
	}



