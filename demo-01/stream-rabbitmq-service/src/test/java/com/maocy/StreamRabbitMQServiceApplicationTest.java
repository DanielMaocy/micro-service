package com.maocy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.maocy.receive.SinkSender;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=StreamRabbitMQServiceApplication.class)
@WebAppConfiguration
public class StreamRabbitMQServiceApplicationTest {
    
	@Autowired
	private SinkSender sinkSender;
	
	@Test
	public void contextLoad() {
		for (int i = 0; i < 50; i++) {
			sinkSender.output().send(MessageBuilder.withPayload("From SinkSender").build());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
