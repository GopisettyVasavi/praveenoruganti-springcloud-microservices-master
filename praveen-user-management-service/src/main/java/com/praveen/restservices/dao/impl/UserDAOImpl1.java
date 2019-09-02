package com.praveen.restservices.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import com.praveen.restservices.config.UserRowMapper1;
import com.praveen.restservices.dao.UserDAO1;
import com.praveen.restservices.model.User1;

@Service
public class UserDAOImpl1 implements UserDAO1 {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	UserDAOImpl1(DataSource dataSource1) {
		this.jdbcTemplate = new JdbcTemplate(dataSource1);
	}

	@Override
	public List<User1> findAll1() {
		return jdbcTemplate.query("select * from users1", new UserRowMapper1());
	}

	@Override
	public User1 findUserByName1(String name1) {
		return jdbcTemplate.queryForObject("select * from users1 where userName=?", new Object[] { name1 },
				new UserRowMapper1());
	}

	@Override
	public User1 create1(User1 user1) throws Exception {
		
		if(!isUserExists(user1)) {
			final String sql = "insert into users1(userName,userEmail,address) values(?,?,?)";
			KeyHolder holder = new GeneratedKeyHolder();
			jdbcTemplate.update(new PreparedStatementCreator() {
				@Override
				public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
					PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
					ps.setString(1, user1.getUserName());
					ps.setString(2, user1.getUserEmail());
					ps.setString(3, user1.getAddress());
					return ps;
				}
			}, holder);
			int newUserId = holder.getKey().intValue();
			user1.setUserId(newUserId);
			return user1;
		}else {
			throw new Exception("User Already Exists");
		}
	}

	@Override
	public int delete1(User1 user1) throws Exception {
		final String deleteSql = "delete from users1 where userName=? and userEmail=? and address=?";
		Object[] params = { user1.getUserName(), user1.getUserEmail(), user1.getAddress() };
		int rows = jdbcTemplate.update(deleteSql, params);
		if (rows > 0) {
			return rows;
		} else {
			throw new Exception("User doesn't Exists");
		}
	}
	
	public boolean isUserExists(User1 user1) {
		final String sql = "select COUNT(1) from users1 where userName=? and userEmail=? and address=?";
		Object[] params = { user1.getUserName(), user1.getUserEmail(), user1.getAddress() };
		int row=  jdbcTemplate.queryForObject(sql, params,Integer.class);
		if(row>0) {
			return true;
		}else {
			return false;
		}
	}

}
