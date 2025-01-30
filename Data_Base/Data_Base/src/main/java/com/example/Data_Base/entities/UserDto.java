package com.example.Data_Base.entities;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	
	private int userIdDto;
	private String passwordDto;

	private String userRoleDto;
	private String username;
	
	private LocalDateTime registrationDateTime;
	
}
