package com.praveen.restservices.dao;

import java.util.List;

import com.praveen.restservices.model.User1;

public interface UserDAO1 {
	abstract List<User1> findAll1();
	abstract User1 findUserByName1(String name1);
	abstract User1 create1(final User1 user1) throws Exception;
	abstract int delete1(final User1 user1) throws Exception;

}
