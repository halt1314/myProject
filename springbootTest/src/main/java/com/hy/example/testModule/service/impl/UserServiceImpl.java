package com.hy.example.testModule.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hy.example.testModule.dao.UserDao;
import com.hy.example.testModule.entity.User;
import com.hy.example.testModule.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	@Override
	public List<User> getUsersByUserId(int userId) {
		return userDao.getUsersByUserId(userId);
		
	}

	@Override
	public void insertUser(User user) {
		userDao.insertUser(user);
		
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
		
	}

	@Override
	public void deleteUser(int userId) {
		userDao.deleteUser(userId);
		
	}
	
	
}
