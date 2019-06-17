package com.maocy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
