package com.nt.receiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.nt.model.ActorInfo;

@Component
public class ObjectMessageReceiver 
{
	@JmsListener(destination = "obj_mq")
	public void readMessage(ActorInfo actorInfo)
	{
		System.out.println("Recevied Obj Message : " + actorInfo);
	}
}
