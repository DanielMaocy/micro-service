package com.maocy.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SystemController {
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String hello(HttpServletRequest request) {
		String result = "hello Sleuth(2) : 【tradeId】" 
				+ request.getHeader("X-B3-TraceId")
				+ "【SpanId】" + request.getHeader("X-B3-SpanId")
				+ "【ParentSpanId】" + request.getHeader("X-B3-ParentSpanId");
		System.out.println("head:" + result);
		return result;
	}

}
