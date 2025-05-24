package com.nt.consumer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MessageStore 
{
	private List<String> listMessages = new ArrayList<String>();
	
	public void addMessage(String ms)
	{
		listMessages.add(ms);
	}
	
	public List<String> getMessages()
	{
		return listMessages;
	}
}
