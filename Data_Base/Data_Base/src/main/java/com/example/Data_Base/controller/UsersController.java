package com.example.Data_Base.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Data_Base.entities.Users;
import com.example.Data_Base.service.UserService;

@RestController
public class UsersController {
	
	@Autowired
	private UserService userService;
	 
	

	//	Getting Data
	@GetMapping("/displaying/Users")
	public List<Users> getUsers(){
		return userService.getAllUsers();
		
	}

	//	Inserting Data
	@PostMapping("/inserting/Users")
	public void userInsert(@RequestBody Users user) {
		userService.insertUser(user);
	}
	

	//	Updating Data
	@PutMapping("/Updating/Users/{Id}")
	public void userUpdate(@PathVariable int id ,@RequestBody Users user) {
		userService.usersUpdate(id, user);
	}

	//	Deleting Data
	@DeleteMapping("/deleting/Users/{Id}")
	public void userDelete(@PathVariable int userId) {
		userService.deleteUserById(userId);
	}

	//	GettingData by password
	@GetMapping("/password/{password}")
	public Optional<Users> getUsersByPassword(@PathVariable String password) {
        return userService.getUsersByPassword(password);
    }
	

}
