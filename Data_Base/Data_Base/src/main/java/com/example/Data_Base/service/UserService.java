package com.example.Data_Base.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;



import com.example.Data_Base.entities.Users;
import com.example.Data_Base.repository.UsersRepository;


@Service
public class UserService {
	
        @Autowired
	    private UsersRepository usersRepository;

	    // Create or insert a User
	    public void insertUser(Users user) {
	       usersRepository.save(user);
	    }
	    
	    
	    // Get a User by ID
	    public Optional<Users> getUserById(int userId) {
	        return usersRepository.findById((long)userId);
	        
	    }

	   
	    // Get all Users
	    public List<Users> getAllUsers() {
	        return usersRepository.findAll();
	    }

	    
	    
	    // Update an existing User	    
	    public void usersUpdate( int id , Users user) {
		   Users usersupdate =  usersRepository.findById((long)id).get();
		   usersupdate.setPassword(user.getPassword());
		   usersupdate.setRegistrationDateTime(user.getRegistrationDateTime());
		   usersupdate.setUsername(user.getUsername());
		   usersupdate.setUserRole(user.getUserRole());
		   usersRepository.save(usersupdate);
		   
		   
	   }

	    // Delete a User by ID
	    public void deleteUserById(int userId) {
	        usersRepository.deleteById((long)userId);
	    }
	    

	    
	    //Getting data by password
	    public Optional<Users> getUsersByPassword(String userPassword) {
	        return usersRepository.findByPassword(userPassword);
	}
	    
}

	


