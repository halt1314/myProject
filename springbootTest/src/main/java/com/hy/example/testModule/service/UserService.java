package com.hy.example.testModule.service;

import java.util.List;

import com.hy.example.testModule.entity.User;

public interface UserService {
	
	List<User> getUsersByUserId(int userId);
	void insertUser(User user);
	void updateUser(User user);
	void deleteUser(int userId);
}
