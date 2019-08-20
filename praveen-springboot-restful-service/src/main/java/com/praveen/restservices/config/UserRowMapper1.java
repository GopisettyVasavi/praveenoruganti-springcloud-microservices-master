package com.praveen.restservices.config;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.praveen.restservices.model.User1;

public class UserRowMapper1 implements RowMapper<User1> {
	@Override
	public User1 mapRow(ResultSet rs, int rowNum) throws SQLException {
		User1 user1 = new User1();
		user1.setUserId(rs.getInt("userId"));
		user1.setUserName(rs.getString("userName"));
		user1.setUserEmail(rs.getString("userEmail"));
		user1.setAddress(rs.getString("address"));
		return user1;
	}
}