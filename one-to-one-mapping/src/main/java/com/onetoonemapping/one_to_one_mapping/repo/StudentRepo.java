package com.onetoonemapping.one_to_one_mapping.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onetoonemapping.one_to_one_mapping.entities.Student;

public interface StudentRepo extends JpaRepository<Student, Long>{

}
