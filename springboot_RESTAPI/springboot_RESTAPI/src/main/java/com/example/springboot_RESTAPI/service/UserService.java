package com.example.springboot_RESTAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.springboot_RESTAPI.entities.User;
import com.example.springboot_RESTAPI.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	

	//	displaying 
	public List<User> displayUser(){
		return userRepo.findAll();
		
	}
	
   //	Adding data
	public void insertUser(@RequestBody User us) {
		userRepo.save(us);
	}
	
   //	Deleting id
	public void deleteUser(@PathVariable int id) {
		userRepo.deleteById((long)id);
	}
	
   //	Updating Data
	public void updatingUser(@PathVariable int id, @RequestBody User us) {
		User ue = userRepo.findById((long)id).get();
		ue.setDob(ue.getDob());
		ue.setName(ue.getName());
	}

}
