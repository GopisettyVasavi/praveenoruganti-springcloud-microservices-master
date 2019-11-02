package com.praveen.springboot.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praveen.springboot.web.model.Login;
import com.praveen.springboot.web.model.User;
import com.praveen.springboot.web.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public UserRepository userRepo;

	public void addUser(User user) {
		userRepo.save(user);
	}

	public User validateUser(Login login) {
		return userRepo.findByUsername(login.getUsername(), login.getPassword());
	}

}
