package com.maocy.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maocy.entity.User;

@RestController
public class SystemController {
	
	@Autowired
	private DiscoveryClient client;
	
	@RequestMapping("/index")
	public String index() {
		@SuppressWarnings("deprecation")
		ServiceInstance instance = client.getLocalServiceInstance();
		System.out.println("/hello, host:" + instance.getHost() + ", service id:" + instance.getServiceId());
		return "Hello World ...";
	}
	
	@RequestMapping("/login")
	public String login(String name, String password) {
		String result = "name=" + name + " password=" + password + ": " + System.currentTimeMillis();
		System.out.println(result);
		return result;
	}
	
	@RequestMapping("/user-get")
	public User getUser(String id) {
		User user = new User(id);
		System.out.println("/user-get == >" + user.toString());
		return user;
	}
	
	@RequestMapping("/user-get-all")
	public List<User> getUserAll(String[] ids) {
		if (null == ids || ids.length == 0) {
			return null;
		}
		
		List<User> result = new ArrayList<User>();
		for (String id : ids) {
			result.add(new User(id));
		}
		
		System.out.println("/user-get-all == >" + result.toString());
		return result;
	}
	
	@RequestMapping(value="/name-get", method=RequestMethod.GET)
	public String getName(@RequestParam String name) {
		System.out.println("getName==>" + name);
		return name;
	}
	
	@RequestMapping(value="/user-init", method=RequestMethod.GET)
	public User initUser(@RequestHeader String name, @RequestHeader Integer age) {
		User user = new User(String.valueOf(System.currentTimeMillis()), name, age);
		System.out.println("initUser==>" + user);
		return user;
	}
	
	@RequestMapping(value="/user-add", method=RequestMethod.POST)
	public User addUser(@RequestBody User user) {
		System.out.println("addUser==>" + user.toString());
		return user;
	}
}
