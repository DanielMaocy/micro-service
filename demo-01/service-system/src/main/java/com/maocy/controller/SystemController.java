package com.maocy.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
