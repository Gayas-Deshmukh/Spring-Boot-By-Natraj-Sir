package com.nt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nt.model.Customer;


@RestController
@RequestMapping("/cust")
public class CustomerController
{
	@PostMapping("/register")
	public ResponseEntity<String> registorCustomer(@RequestBody Customer cust)
	{
		return new ResponseEntity<String>(cust.toString(), HttpStatus.OK);
	}
}
