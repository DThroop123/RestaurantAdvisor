package com.example.demo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.UserDAO;
import com.example.demo.domain.User;


@Component
public class UserService {

@Autowired
UserDAO userDAO;
	
	public List<User> getUserList() {
		return userDAO.getUserList();
	}

	public void saveUser(User user) {
		userDAO.saveUser(user);
	}
	
	public void registerUser(User user) {
		userDAO.registerUser(user);
	}
}	