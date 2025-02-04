package com.example.Data_Base.entities;


import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Registered_table")
public class RegisterdCourses {
	@Id
	private int registrationId;

	@ManyToOne
	@JoinColumn(name = "user_id")
//	@Column(name = "user_id")
	private Users userId;

	@ManyToOne
	@JoinColumn(name = "course_id")
//	@Column(name = "course_id")
	private Course courseId;

	
	

	

}
