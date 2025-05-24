package com.nt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/cust")
public class CustomerController
{
	@GetMapping("/report/{cno}/{cname}")
	public ResponseEntity<String> getCustomerReport(@PathVariable("cno") Integer cno,
													@PathVariable("cname") String cName)
	{
		return new ResponseEntity<String>(cno + "....." + cName, HttpStatus.OK);
	}
}
