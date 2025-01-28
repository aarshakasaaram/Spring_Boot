package com.example.springboot_RESTAPI.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot_RESTAPI.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

}
