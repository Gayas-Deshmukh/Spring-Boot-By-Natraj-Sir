package com.nt.sender;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.Session;


//@Component
public class ActiveMQMessageSenderRunner implements CommandLineRunner 
{
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Override
	public void run(String... args) throws Exception
	{
		/*
		jmsTemplate.send("testMQ", new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException 
			{
				return session.createTextMessage("From Sender :" + new Date());
			}
		});
		*/
		
		// OR
		
		jmsTemplate.send("testMQ", (ses) -> ses.createTextMessage("From Sender :" + new Date()));
		
		System.out.println("Message Send");
	}

}
