package com.maocy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maocy.entity.User;
import com.maocy.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	public String getUserName(String name) {
		return userService.getUserName(name);
	}

	public User initUser(String name, Integer age) {
		return userService.initUser(name, age);
	}

	public User addUser(User user) {
		return userService.addUser(user);
	}
}
