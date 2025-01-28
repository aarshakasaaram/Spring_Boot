package com.example.springboot_RESTAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot_RESTAPI.entities.Posts;

import com.example.springboot_RESTAPI.service.PostsService;


@RestController
public class PostsController {
         
	@Autowired
	private PostsService postsService;
	
	@GetMapping("Posts/display")
	public List<Posts> postsDisplay(){
		return postsService.displayPosts();
		
	}
	
	@PostMapping("Posts/insert")
	public void userInsert(@RequestBody Posts pt) {
		postsService.insertPosts(pt);
	}
	
	@PutMapping("Posts/update/{Id}")
	public void userUpdate(@PathVariable int id, @RequestBody Posts pt) {
		postsService.updatingPosts(id, pt);
		
	}
	
	@DeleteMapping("Users/Delete/{Id}")
	public void userDelete(@PathVariable int id) {
		postsService.deletePosts(id);
	}
}
