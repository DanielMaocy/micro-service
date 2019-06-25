package com.maocy.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RabbitListener(queues="test")
public class MessageReceiver {

	@RabbitHandler
	public void process(String data) {
		System.out.println("Receiver > " + data);
	}
}
