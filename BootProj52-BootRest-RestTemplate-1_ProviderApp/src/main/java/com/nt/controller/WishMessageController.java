package com.nt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wish-api")
public class WishMessageController 
{
	@GetMapping("/wish")
	public ResponseEntity<String> getWishMsg()
	{
		return new ResponseEntity<String>("Good Morning", HttpStatus.OK);
	}
	
	@GetMapping("/wish/{name}/{location}")
	public ResponseEntity<String> getCustomeWishMsg(@PathVariable("name") String name, @PathVariable("location") String location)
	{
		return new ResponseEntity<String>("Good Morning :: " + name + "..." + location, HttpStatus.OK);
	}
}
