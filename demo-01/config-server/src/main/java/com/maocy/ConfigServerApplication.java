package com.maocy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer // 开启Spring Cloud Config的服务端功能
@SpringBootApplication
public class ConfigServerApplication {
	
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
