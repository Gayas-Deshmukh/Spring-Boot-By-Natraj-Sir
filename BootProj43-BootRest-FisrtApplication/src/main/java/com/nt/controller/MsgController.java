package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/*
@ResponseBody
@Controller()
*/

@RestController
@RequestMapping("/first-app")
public class MsgController 
{
	@GetMapping("/msg")
	public String getWelcomeMsg()
	{
		return "Welcome to spring boot rest";
	}
}
