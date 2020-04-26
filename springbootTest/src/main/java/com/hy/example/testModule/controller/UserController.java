package com.hy.example.testModule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hy.example.testModule.entity.User;
import com.hy.example.testModule.service.UserService;

@RestController
@RequestMapping("/UserController")
public class UserController {
	
	@Autowired
	private UserService userService;
	@RequestMapping("/user/{userId}")
	public List<User> getUserByUserId(@PathVariable int userId) {
	
		return userService.getUsersByUserId(userId);
			
	}
	
 	@PostMapping(value="/user", consumes="application/json")
 	public void inserUser(@RequestBody User user) {
 		userService.insertUser(user);
 	}
 	
 	@PutMapping(value="/user", consumes="application/x-www-form-urlencoded")
	public void updateUser(@ModelAttribute User user) {
		userService.updateUser(user);
	}
 	@DeleteMapping("/user/{userId}")
	public void deleteUser(@PathVariable int userId) {
 		userService.deleteUser(userId);
	}
}
