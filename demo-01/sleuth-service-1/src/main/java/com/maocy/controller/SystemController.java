package com.maocy.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SystemController {

	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String hello(HttpServletRequest request) {
		String result = "hello Sleuth(1) : 【tradeId】" 
				+ request.getHeader("X-B3-TraceId")
				+ "【SpanId】" + request.getHeader("X-B3-SpanId")
				+ "【ParentSpanId】" + request.getHeader("X-B3-ParentSpanId") + "\n";
		System.out.println("head:" + result);
		String content = restTemplate.getForObject("http://sleuth-service-2/hello", String.class);
		result += content;
		return result;
	}
}
