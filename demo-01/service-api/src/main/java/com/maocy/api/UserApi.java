package com.maocy.api;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.maocy.entity.User;

@RequestMapping("/user")
public interface UserApi {

	@RequestMapping(value="/name-get", method=RequestMethod.GET)
	public String getUserName(@RequestParam("name") String name);
	
	@RequestMapping(value="/init", method=RequestMethod.GET)
	public User initUser(@RequestHeader("name") String name, @RequestHeader("age") Integer age);
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public User addUser(@RequestBody User user);
}
