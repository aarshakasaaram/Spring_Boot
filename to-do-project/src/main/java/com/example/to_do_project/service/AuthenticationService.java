package com.example.to_do_project.service;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	
	
	public boolean authenticate(String username, String password) {
		boolean isValidUserName = username.equalsIgnoreCase("in28minutes");
		boolean isValidPassword = password.equalsIgnoreCase("dummy");
		return isValidUserName && isValidPassword;
	}

}
