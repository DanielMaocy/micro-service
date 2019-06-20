package com.maocy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.maocy.entity.User;
import com.maocy.service.SystemService;

@RestController
@RequestMapping("/feign-sys")
public class SystemController {

	@Autowired
	private SystemService systemService;
	
	@RequestMapping("/index")
	public String index() {
		return systemService.index();
	}
	
	@RequestMapping(value="/name-get", method=RequestMethod.GET)
	public String getName(String name) {
		return systemService.getName(name);
	}
	
	@RequestMapping(value="/user-init", method=RequestMethod.GET)
	public User initUser(String name, Integer age) {
		return systemService.initUser(name, age);
	}
	
	@RequestMapping(value="/user-add", method=RequestMethod.POST)
	public User addUser(User user) {
		return systemService.addUser(user);
	}
}
