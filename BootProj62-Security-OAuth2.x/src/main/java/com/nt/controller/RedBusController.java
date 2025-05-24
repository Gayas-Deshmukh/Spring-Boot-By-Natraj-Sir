package com.nt.controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RedBusController 
{
	@GetMapping("/home")
	public String showHome()
	{
		return "Hello, Welcome to homepage of Redbus.com";
	}
	
	@GetMapping("/after")
	public String afterLoginPage()
	{
		return "Hello, Successfully logged into Redbus.com";
	}
	
	@GetMapping("/user")
	public Authentication showUserDetails(Principal principal)
	{
		System.out.println("LoggedIn User Details ::" + principal.getName());
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication(); // Gives more info about logged in user
		return auth;
	}
}
