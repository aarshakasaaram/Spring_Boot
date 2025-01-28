package com.example.springboot_RESTAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.example.springboot_RESTAPI.entities.User;
import com.example.springboot_RESTAPI.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("User/display")
	public List<User> userDisplay(){
		return userService.displayUser();
		
	}
	
	@PostMapping("Users/insert")
	public void userInsert(@RequestBody User us) {
		userService.insertUser(us);
	}
	
	@PutMapping("Users/update/{Id}")
	public void userUpdate(@PathVariable int id, @RequestBody User us) {
		userService.updatingUser(id, us);
		
	}
	
	@DeleteMapping("Users/Delete/{Id}")
	public void userDelete(@PathVariable int id) {
		userService.deleteUser(id);
	}
	
	
	

}
