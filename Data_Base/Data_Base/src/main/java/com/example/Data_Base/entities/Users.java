package com.example.Data_Base.entities;

import java.time.LocalDateTime;


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
@Table(name="Users_table")
public class Users {
	
	@Id
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "user_role")
	private String userRole;
	
	@Column(name = "username")
	private String username;
	
	@Column(name="registrationDateTime")
	private LocalDateTime registrationDateTime;
}


