package com.example.springboot_RESTAPI.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot_RESTAPI.entities.Posts;

@Repository
public interface PostsRepo extends JpaRepository<Posts, Long> {

}
