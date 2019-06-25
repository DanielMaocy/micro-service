package com.maocy.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageProduction {

	@Autowired
	private AmqpTemplate amqpTemplate;
	
	public void send() {
		System.out.println("》》》》》发送消息《《《《《");
		amqpTemplate.convertAndSend("test", "hello rabbitmq...");
	}
}
