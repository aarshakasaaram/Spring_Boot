package com.complextable.complex_table.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.complextable.complex_table.entities.IdCard;

public interface IdCardRepo extends JpaRepository<IdCard, Long>{
	Optional<IdCard> findByStudentId(Long studentId);
}
