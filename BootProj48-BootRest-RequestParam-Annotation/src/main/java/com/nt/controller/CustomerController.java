package com.nt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/cust")
public class CustomerController
{
	/*
	@GetMapping("/report")
	public ResponseEntity<String> getCustomerReport(@RequestParam("cno") Integer cno, @RequestParam("cname") String cName)
	{
		return new ResponseEntity<String>(cno + "....." + cName, HttpStatus.OK);
	}
	*/
	
	/*
	@GetMapping("/report")
	public ResponseEntity<String> getCustomerReport(@RequestParam("cno") Integer cno, 
													@RequestParam(name = "cname", required = false) String cName)
	{
		return new ResponseEntity<String>(cno + "....." + cName, HttpStatus.OK);
	}
	*/
	
	@GetMapping("/report")
	public ResponseEntity<String> getCustomerReport(@RequestParam("cno") Integer cno, 
													@RequestParam(name = "cname", required = false, defaultValue = "Sample") String cName)
	{
		return new ResponseEntity<String>(cno + "....." + cName, HttpStatus.OK);
	}
}
