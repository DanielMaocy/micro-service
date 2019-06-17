package com.maocy.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("service-system")
public interface SystemService {

	@RequestMapping("/index")
	public String index();
}
