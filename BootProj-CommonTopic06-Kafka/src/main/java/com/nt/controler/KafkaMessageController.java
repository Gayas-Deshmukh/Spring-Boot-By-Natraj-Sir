package com.nt.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nt.consumer.MessageStore;
import com.nt.producer.MessageProducer;

@RestController
@RequestMapping("kafka-api")
public class KafkaMessageController 
{
	@Autowired
	private MessageProducer producer;
	
	@Autowired
	private MessageStore store;
	
	@GetMapping("/send")
	public ResponseEntity<String> sendMessage(@RequestParam("msg") String message)
	{
		return new ResponseEntity<String>(producer.sendMessage(message), HttpStatus.OK);
	}
	
	@GetMapping("/readAll")
	public ResponseEntity<List<String>> readAllMessages()
	{
		return new ResponseEntity<List<String>>(store.getMessages(), HttpStatus.OK);
	}
}
