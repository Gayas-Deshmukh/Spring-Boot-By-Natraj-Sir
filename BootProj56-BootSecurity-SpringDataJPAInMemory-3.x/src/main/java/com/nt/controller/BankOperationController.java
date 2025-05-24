package com.nt.controller;

import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank")
public class BankOperationController 
{
	@GetMapping("/welcome")
	public ResponseEntity<String> showHome()
	{
		return new ResponseEntity<String>("Welcome to home page", HttpStatus.OK);
	}
	
	@GetMapping("/offers")
	public ResponseEntity<String> showOffers()
	{
		return new ResponseEntity<String>("Offer page", HttpStatus.OK);
	}
	
	@GetMapping("/balance")
	@PreAuthorize("hasAnyAuthority('MANAGER','CUSTOMER')")
	public ResponseEntity<String> checkBalance()
	{
		int amount = new Random().nextInt(2000000);
		return new ResponseEntity<String>("Lone Approved amount : " + amount, HttpStatus.OK);
	}
	
	@GetMapping("/loan_approve")
	@PreAuthorize("hasAuthority('MANAGER')")
	public ResponseEntity<String> loanApprove()
	{
		int amount = new Random().nextInt(2000000);
		return new ResponseEntity<String>("Lone Approved amount : " + amount, HttpStatus.OK);
	}
}
