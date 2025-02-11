package com.example.restapi.usecase.employee.student.project.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Student")
public class Student {
	
	@Id
	@Column(name = "student_id")
	private long studentId;
	
	@Column(name = "student_name")
	private String studentName;
	
	@Column(name = "student_branch")
	private String studentBranch;
	
	@Column(name = "student_rollno")
	private long studentRollno;
}
