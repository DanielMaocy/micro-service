package com.maocy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.maocy.entity.User;
import com.maocy.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value="/name-get", method=RequestMethod.GET)
	public String getUserName(String name) {
		return userService.getUserName(name);
	}

	@RequestMapping(value="/init", method=RequestMethod.GET)
	public User initUser(String name, Integer age) {
		return userService.initUser(name, age);
	}

	@RequestMapping(value="/add", method=RequestMethod.POST)
	public User addUser(User user) {
		return userService.addUser(user);
	}
}
