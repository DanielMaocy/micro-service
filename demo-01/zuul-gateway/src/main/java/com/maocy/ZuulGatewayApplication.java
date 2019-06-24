package com.maocy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.maocy.filters.AccessFilter;

@EnableZuulProxy // 开启Zuul的API网关服务功能
@SpringBootApplication
public class ZuulGatewayApplication {
	
	@Bean
	public AccessFilter accessFilter() {
		return new AccessFilter();
	}
	
    public static void main(String[] args) {
        SpringApplication.run(ZuulGatewayApplication.class, args);
    }
}
