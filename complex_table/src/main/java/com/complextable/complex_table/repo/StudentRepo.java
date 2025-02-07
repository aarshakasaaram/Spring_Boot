package com.complextable.complex_table.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.complextable.complex_table.entities.IdCard;
import com.complextable.complex_table.entities.Student;

    public interface StudentRepo extends JpaRepository<Student, Long>{
    	  List<Student> findByDepartmentId(Long departmentId);
    	  

	
}
