package com.nt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cust")
public class CustomerController
{
	@GetMapping("/report")
	public ResponseEntity<String> showCustomerReport()
	{
		return new ResponseEntity<String>("From GET- showCustomerReport method", HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> registerCustomer()
	{
		return new ResponseEntity<String>("From POST- registerCustomer method", HttpStatus.OK);
	}
	
	@PutMapping("/modify")
	public ResponseEntity<String> updateCustomer()
	{
		return new ResponseEntity<String>("From PUT- updateCustomer method", HttpStatus.OK);
	}
	
	@PatchMapping("/pmodify")
	public ResponseEntity<String> updateCustomerByNo()
	{
		return new ResponseEntity<String>("From PATCH- updateCustomerByNo method", HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteCustomer()
	{
		return new ResponseEntity<String>("From DELETE- deleteCustomer method", HttpStatus.OK);
	}
}
