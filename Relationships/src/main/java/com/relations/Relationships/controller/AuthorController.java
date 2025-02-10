package com.relations.Relationships.controller;

import org.springframework.web.bind.annotation.RestController;

import com.relations.Relationships.entities.Author;
import com.relations.Relationships.entities.Book;
import com.relations.Relationships.service.AuthorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class AuthorController {
    @Autowired
    AuthorService b;
     @GetMapping("/authors")
    public ArrayList<Author>  getAuthors(){
      
        return b.getAuthors();
    }
    @GetMapping("/authors/{authorId}")
    public Author getMethodName(@PathVariable("authorId") int id) {
        return b.getAuthorById(id);
    }
    
    @PostMapping("/authors")
    public Author postMethodName(@RequestBody Author author) {
       return b.addAuthor(author);
    }
    @PutMapping("/authors/{authorId}")
    public Author putMethodName(@PathVariable("authorId") int id, @RequestBody Author author) {
        
        return b.updateAuthor(id,author);
    }
    @DeleteMapping("/authors/{authorId}")
    public String delete(@PathVariable("authorId") int id) {
        b.deleteAuthor(id);
        return "book deleted successfully";
    }
    @GetMapping("/authors/{authorId}/books")
    public List<Book> getbooks(@PathVariable("authorId ") int id) {
        return b.getAuthorBooks(id);
    }
    
}