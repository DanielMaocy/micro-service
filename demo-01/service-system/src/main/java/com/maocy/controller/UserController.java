package com.maocy.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maocy.api.UserApi;
import com.maocy.entity.User;

@RestController
public class UserController implements UserApi {

	@Override
	public String getUserName(@RequestParam("name") String name) {
		System.out.println("【UserController】【getUserAge】" + name);
		return name;
	}

	@Override
	public User initUser(@RequestHeader("name") String name, @RequestHeader("age") Integer age) {
		User user = new User(String.valueOf(System.currentTimeMillis()), name, age);
		System.out.println("【UserController】【initUser】" + user);
		return user;
	}

	@Override
	public User addUser(@RequestBody User user) {
		System.out.println("【UserController】【addUser】" + user);
		return user;
	}
}
