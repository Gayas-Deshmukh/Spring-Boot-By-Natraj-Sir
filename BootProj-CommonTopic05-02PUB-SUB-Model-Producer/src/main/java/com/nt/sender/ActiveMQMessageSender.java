package com.nt.sender;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQMessageSender 
{
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Scheduled(cron = "*/10 * * * * *")
	public void sendMessage()
	{
		jmsTemplate.send("topicMQ", (ses) -> ses.createTextMessage("From Sender :" + new Date()));
		
		System.out.println("Message Send");
	}
}
