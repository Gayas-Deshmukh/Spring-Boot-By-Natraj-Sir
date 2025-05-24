package com.nt.receiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JmsMessageConsumer 
{
	@JmsListener(destination = "topicMQ")
	public void readMessage(String msg)
	{
		System.out.println("Recevied Message : " + msg);
	}
}
