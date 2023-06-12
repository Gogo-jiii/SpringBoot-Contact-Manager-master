package com.example.demo.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.models.User;

public interface UserRepo extends CrudRepository<User, Integer> {

	@Query("select u from User u where u.email =:email")
	public User getUserByUsername(@Param("email") String email);
	
}
