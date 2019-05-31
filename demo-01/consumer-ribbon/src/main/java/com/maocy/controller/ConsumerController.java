package com.maocy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping("/index")
	public String index() {
		String result = restTemplate.getForEntity("http://service-system/index", String.class).getBody();
		return result;
	}
	
	@RequestMapping("/login")
	public String login() {
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(
				"http://service-system/login?name={1}&password={2}", String.class, "admin", "123456");
		String result = responseEntity.getBody();
		return result;
	}
}
