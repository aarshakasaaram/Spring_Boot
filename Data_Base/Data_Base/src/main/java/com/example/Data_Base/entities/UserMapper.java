package com.example.Data_Base.entities;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {
	
	public UserDto toDto(Users users) {
		return new UserDto(
		users.getUserId(),
	    users.getPassword(),
	    users.getUsername(),
		users.getUserRole(),
		users.getRegistrationDateTime()
		);
		
		
	}
	
	public Users toEntity(UserDto userDto) {
		return new Users(
				userDto.getUserIdDto(),
				userDto.getPasswordDto(),
				userDto.getUsername(),
				userDto.getUserRoleDto(),
				userDto.getRegistrationDateTime()
				);
	}
	
		

}

