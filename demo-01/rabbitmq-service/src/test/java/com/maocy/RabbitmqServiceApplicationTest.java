package com.maocy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.maocy.service.MessageProduction;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=RabbitmqServiceApplication.class)
@WebAppConfiguration
public class RabbitmqServiceApplicationTest {
	
	@Autowired
	MessageProduction messageProduction;
	
	@Test
	public void send() {
		messageProduction.send();
	}
}
