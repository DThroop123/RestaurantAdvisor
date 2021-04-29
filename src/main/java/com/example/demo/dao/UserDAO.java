package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.domain.User;

@Component
public class UserDAO {

	@Autowired
	private UserMapper userMapper;

	public List<User> getUserList() {

		List<User> userList = new ArrayList<User>();

		userList = userMapper.getUserList();

		return userList;
	}

	public void saveUser(User user) {

		userMapper.saveUser(user);
	}
	
	public void registerUser(User user) {
		userMapper.insertUser(user);
	}
}
