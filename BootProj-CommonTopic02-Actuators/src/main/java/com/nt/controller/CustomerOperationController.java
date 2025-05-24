package com.nt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cust")
public class CustomerOperationController 
{
	@GetMapping("/report")
	public String displayCustomerReport()
	{
		return "Welcome to customer report operation";
	}
}
