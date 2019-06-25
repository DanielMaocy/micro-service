package com.maocy;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitmqServiceApplication {
	
	public Queue testQueue() {
		return new Queue("test");
	}
	
    public static void main(String[] args) {
        SpringApplication.run(RabbitmqServiceApplication.class, args);
    }
}
