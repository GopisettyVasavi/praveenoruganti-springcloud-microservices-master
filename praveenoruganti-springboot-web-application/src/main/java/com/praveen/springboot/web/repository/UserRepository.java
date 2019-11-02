package com.praveen.springboot.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.praveen.springboot.web.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	
	@Query(" Select u from User u where u.username=:username and u.password=:password")
	User findByUsername(String username,String password);

}