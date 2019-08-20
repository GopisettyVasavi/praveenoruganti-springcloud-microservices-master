package com.praveen.restservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.praveen.restservices.dao.UserDAO1;
import com.praveen.restservices.model.User1;

@Service
public class UserService1 {
	@Autowired
	private UserDAO1 userDAO1;
 
	@Transactional(readOnly=true)
	public List<User1> findAll1() {
		return userDAO1.findAll1();
	}
	@Transactional(readOnly=true)
	public User1 findUserByName1(String name1) {
		return userDAO1.findUserByName1(name1);
	}

	public User1 create1(final User1 user1) throws Exception{
		return userDAO1.create1(user1);
	}
	
	public int delete1(final User1 user1) throws Exception {
		return userDAO1.delete1(user1);
	}
}
