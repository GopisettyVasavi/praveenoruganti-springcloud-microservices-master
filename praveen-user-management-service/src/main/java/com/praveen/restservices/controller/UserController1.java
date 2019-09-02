package com.praveen.restservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.praveen.restservices.model.User1;
import com.praveen.restservices.service.UserService1;

@RestController
@RequestMapping("/rest")
public class UserController1 {
	@Autowired
	UserService1 userService1;

	// http://localhost:8090/?userName=PraveenOruganti&userEmail=praveenoruganti@gmail.com&address=Hyderabad
	@PostMapping("/adduser1")
	User1 addUser1(User1 user1) throws Exception{
		return userService1.create1(user1);
	}

	@GetMapping("/users1")
	List<User1> findAllUsers1() {		
		return userService1.findAll1();
	}
	
	@GetMapping("/findUser1")
	User1 findUserByName1(@RequestParam String name1) {
		return userService1.findUserByName1(name1);
	}
	
	@DeleteMapping("/deleteuser1")
	int deleteUser1(User1 user1) throws Exception{
		return userService1.delete1(user1);
	}
	
}
