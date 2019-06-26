package com.maocy;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RabbitmqServiceApplication {
	
	@Bean
	public Queue testQueue() {
		return new Queue("test");
	}
	
    public static void main(String[] args) {
        SpringApplication.run(RabbitmqServiceApplication.class, args);
    }
}
