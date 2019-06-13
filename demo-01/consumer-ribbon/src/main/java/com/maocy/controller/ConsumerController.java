package com.maocy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maocy.entity.User;
import com.maocy.service.ConsumerService;

@RestController
public class ConsumerController {

	@Autowired
	ConsumerService consumerService;
	
	@RequestMapping("/index")
	public String index() {
		String result = consumerService.index();
		return result;
	}
	
	@RequestMapping("/login")
	public String login(String id) {
		String result = consumerService.login(id);
		return result;
	}
	
	@RequestMapping("/user-get")
	public User getUser(String id) {
		return consumerService.getUser(id);
	}
	
	@RequestMapping("/user-get-all")
	public List<User> getUserAll(List<String> ids) {
		return consumerService.getUserAll(ids);
	}
}
