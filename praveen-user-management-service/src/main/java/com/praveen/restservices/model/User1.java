package com.praveen.restservices.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//DROP TABLE IF EXISTS users1;
//CREATE TABLE users1(userId int NOT NULL AUTO_INCREMENT,userName VARCHAR(100) NOT NULL,userEmail VARCHAR(100) DEFAULT NULL,address VARCHAR(100) DEFAULT NULL, PRIMARY KEY (userId ));
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class User1 {
	private Integer userId;
	private String userName;
	private String userEmail;
	private String address;
}
