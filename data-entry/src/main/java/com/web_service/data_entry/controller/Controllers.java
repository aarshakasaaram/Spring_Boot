package com.web_service.data_entry.controller;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")

public class Controllers {
	
    @GetMapping
    public String getMethod() {
    	return "getMapping";
    	
    }
    @PostMapping
    public String PostMethod() {
    	return "PostMapping";
    }
    @PutMapping
    public String PutMethod() {
    	return "PutMethod";
    }
    @DeleteMapping
    public String deleteMethod() {
    	return "deleteMethod";
    }


}
