package com.example.Data_Base.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Data_Base.entities.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
	
	@Query(value = "SELECT * FROM Users_table WHERE password = :userPassword", nativeQuery = true)
	Optional<Users> findByPassword(String userPassword);

}
