package com.praveen.springboot.web.service;

import com.praveen.springboot.web.model.Login;
import com.praveen.springboot.web.model.User;

public interface UserService {

  void addUser(User user);

  User validateUser(Login login);
}