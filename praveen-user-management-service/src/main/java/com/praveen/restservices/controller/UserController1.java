package com.praveen.restservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@PostMapping("/adduser1")
	int addUser1(User1 user1) throws Exception {
		return userService1.create1(user1);
	}

	@GetMapping("/users1")
	List<User1> findAllUsers1() throws Exception{
		return userService1.findAll1();
	}

	@GetMapping("/finduser1")
	User1 findUserById1(@RequestParam String userid1) throws Exception {
		return userService1.findUserById1(userid1);
	}

	@PutMapping("/updateuser1")
	int UpdateUserbyId1(User1 userid1) throws Exception {
		return userService1.updateUserbyId1(userid1);
	}

	@DeleteMapping("/deleteuser1")
	void deleteByUserId1(String userId1) throws Exception {
		 userService1.deleteByUserId1(userId1);
	}

}
