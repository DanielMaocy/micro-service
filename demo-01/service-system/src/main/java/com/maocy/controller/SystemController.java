package com.maocy.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maocy.entity.User;

@RestController
public class SystemController {

	private final Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private DiscoveryClient client;
	
	@RequestMapping("/index")
	public String index() {
		@SuppressWarnings("deprecation")
		ServiceInstance instance = client.getLocalServiceInstance();
		logger.info("/hello, host:" + instance.getHost() + ", service id:" + instance.getServiceId());
		return "Hello World ...";
	}
	
	@RequestMapping("/login")
	public String login(String name, String password) {
		int sleepTime = new Random().nextInt(100);
		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String result = "name=" + name + " password=" + password + ": " + System.currentTimeMillis();
		logger.info(result);
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
}
