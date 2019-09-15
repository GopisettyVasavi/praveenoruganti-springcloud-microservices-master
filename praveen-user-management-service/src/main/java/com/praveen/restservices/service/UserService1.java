package com.praveen.restservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.praveen.restservices.dao.UserDAO1;
import com.praveen.restservices.model.User1;

@Service
public class UserService1 {
	@Autowired
	private UserDAO1 userDAO1;
	private HashOperations hashOperations;	
	private RedisTemplate redisTemplate;
	@Autowired
	public UserService1(RedisTemplate redisTemplate) {	
		this.redisTemplate = redisTemplate;
		this.hashOperations = redisTemplate.opsForHash();
	}

	@Transactional(readOnly = true)
	public List<User1> findAll1() throws Exception {
		return userDAO1.findAll1();
	}

	@Transactional(readOnly = true)
	public User1 findUserById1(String userid1) throws Exception {
		if (hashOperations.entries("USER").containsKey(userid1)) {
			return (User1)hashOperations.get("USER", userid1);
		} else {
			return userDAO1.findUserById1(userid1);
		}
	}
	@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED,readOnly=false,timeout=100,rollbackFor=Exception.class)
	public int create1(User1 user1) throws Exception {
		hashOperations.put("USER", String.valueOf(user1.getUserId()), user1);
		return userDAO1.create1(user1);
	}

	public void deleteByUserId1(String userId) throws Exception {
		if (hashOperations.entries("USER").containsKey(userId)) {
			hashOperations.delete("USER", userId);
		}
		 userDAO1.deleteByUserId1(userId);
	}

	public int updateUserbyId1(User1 user1) throws Exception {
		if (hashOperations.entries("USER").containsKey(String.valueOf(user1.getUserId()))) {
			hashOperations.put("USER", String.valueOf(user1.getUserId()), user1);
		}
		return userDAO1.updateUserbyId1(user1);
	}
}
