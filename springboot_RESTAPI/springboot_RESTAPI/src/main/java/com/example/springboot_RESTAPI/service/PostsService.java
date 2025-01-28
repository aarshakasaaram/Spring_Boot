package com.example.springboot_RESTAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.springboot_RESTAPI.entities.Posts;
import com.example.springboot_RESTAPI.repo.PostsRepo;

@Service
public class PostsService {
	
	@Autowired
	private PostsRepo postRepo;
    
	
   //	Displaying data 
	public List<Posts> displayPosts(){
		return postRepo.findAll();
	}
	
   //	Adding data
	public void insertPosts(@RequestBody Posts pt) {
		postRepo.save(pt);
	}
	
   //	Deleting Data
	public void deletePosts(@PathVariable int id) {
		postRepo.deleteById((long)id);
		
	}
	
   //	Updating Data
	public void updatingPosts(@PathVariable int id, @RequestBody Posts pt) {
		Posts po = postRepo.findById((long)id).get();
		po.setDescription(pt.getDescription());
	}
}
