package com.praveen.restservices.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.praveen.restservices.dao.UserDAO1;
import com.praveen.restservices.model.User1;

@Repository
public class UserDAOImpl1 implements UserDAO1 {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	UserDAOImpl1(DataSource dataSource1) {
		this.jdbcTemplate = new JdbcTemplate(dataSource1);
	}

	class UserRowMapper1 implements RowMapper<User1> {
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
	
	@Override
	public List<User1> findAll1() throws Exception {
		List<User1> userList = jdbcTemplate.query("select * from users1", new UserRowMapper1());
		if (userList.size() > 0) {
			return userList;
		} else {
			throw new Exception("No User records found in DB");
		}

	}

	@Override
	public User1 findUserById1(String userid1) throws Exception {
		if (isUserExistsByID(userid1)) {
			User1 user1 = jdbcTemplate.queryForObject("select * from users1 where userId=?",
					new Object[] { Integer.parseInt(userid1) }, new UserRowMapper1());
			return user1;
		} else {
			throw new Exception("User Doesn't Exist");
		}
	}

	@Override
	public int create1(User1 user1) throws Exception {
		if (!isUserExistsByID(String.valueOf(user1.getUserId())) && !isUserExists(user1)) {
			final String insertSql = "insert into users1(userId,userName,userEmail,address) values(?,?,?,?)";
			Object[] params = { user1.getUserId(), user1.getUserName(), user1.getUserEmail(), user1.getAddress() };
			return jdbcTemplate.update(insertSql, params);
		} else {
			throw new Exception("User Already Exists");
		}
	}

	@Override
	public void deleteByUserId1(String userId1) throws Exception {
		if (isUserExistsByID(userId1)) {
			final String deleteSql = "delete from users1 where userId=?";
			jdbcTemplate.update(deleteSql, userId1);			
		} else {
			throw new Exception("User doesn't Exists");
		}
	}

	public boolean isUserExistsByID(String userid1) {
		final String sql = "select COUNT(1) from users1 where userId=?";
		Object[] params = { Integer.parseInt(userid1) };
		int row = jdbcTemplate.queryForObject(sql, params, Integer.class);
		if (row > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isUserExists(User1 user1) {
		final String sql = "select COUNT(1) from users1 where userName=? and userEmail=? and address=?";
		Object[] params = { user1.getUserName(), user1.getUserEmail(), user1.getAddress() };
		int row = jdbcTemplate.queryForObject(sql, params, Integer.class);
		if (row > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int updateUserbyId1(User1 user1) throws Exception {
		if (isUserExistsByID(String.valueOf(user1.getUserId()))) {
			final String updateSql = "update users1 set userName=? , userEmail=? , address=? where userId=?";
			int rows = jdbcTemplate.update(updateSql, user1.getUserName(), user1.getUserEmail(), user1.getAddress(),
					user1.getUserId());
			return rows;
		} else {
			throw new Exception("User Doesn't Exist");
		}
	}

}
