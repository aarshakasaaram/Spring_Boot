package com.example.Data_Base.entities;

import java.time.LocalDateTime;


import jakarta.persistence.Column;

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
@Table(name = "favouriteTable")
public class FavouriteCourse {
	
	@Id
	@Column(name = "favourite_id")
	private int favouriteId;

	@ManyToOne
	@JoinColumn(name = "registration_id")
//	@Column(name = "registration_id")
	private RegisterdCourses registrationId;

	

	
}
