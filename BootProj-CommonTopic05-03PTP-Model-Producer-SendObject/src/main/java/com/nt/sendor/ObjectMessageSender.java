package com.nt.sendor;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.nt.model.ActorInfo;

@Component
public class ObjectMessageSender 
{
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Scheduled(cron = "*/10 * * * * *")
	public void sendMessage()
	{
		ActorInfo actorInfo = new ActorInfo(1, "Salman", "Mumbai");
		
		jmsTemplate.convertAndSend("obj_mq", actorInfo);
		
		System.out.println("Obj is sent as message");
	}
}
