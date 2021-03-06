package com.maocy.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.maocy.entity.User;

@FeignClient("service-system")
public interface SystemService {

	@RequestMapping("/index")
	public String index();
	
	@RequestMapping(value="/name-get", method=RequestMethod.GET)
	public String getName(@RequestParam("name") String name);
	
	@RequestMapping(value="/user-init", method=RequestMethod.GET)
	public User initUser(@RequestHeader("name") String name, @RequestHeader("age") Integer age);
	
	@RequestMapping(value="/user-add", method=RequestMethod.POST)
	public User addUser(@RequestBody User user);
}
