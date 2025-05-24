package com.nt.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Company;
import com.nt.model.Customer;

@RestController
@RequestMapping("/cust")
public class CustomerController
{
	/*
	@GetMapping("/report")
	public ResponseEntity<Customer> getCustomerReport()
	{
		Customer cust = new Customer(125, "Rahul", 560.0d);
		
		return new ResponseEntity<Customer>(cust, HttpStatus.OK);
	}
	*/
	
	/*
	@GetMapping("/report")
	public ResponseEntity<Customer> getCustomerReport()
	{
		Customer cust = new Customer();
		
		cust.setCno(500);
		cust.setCname("Prakash");
		cust.setBillamt(5000d);
		cust.setFavColor(new String [] {"Blue", "Red", "Green"});
		cust.setStudies(List.of("10th", "12th", "Graduate"));
		cust.setPhoneNums(Set.of(1258963l, 899999l));
		cust.setIdDetails(Map.of("Adhar", 589678963214l, "PAN", "ERFDFF85F"));
		
		Company comp = new Company("Test", "Mumbai", 30);
		
		cust.setCompany(comp);
		
		return new ResponseEntity<Customer>(cust, HttpStatus.OK);
	}
	*/
	
	@GetMapping("/report")
	public ResponseEntity<List<Customer>> getCustomerReport()
	{
		Customer cust1 = new Customer();
		
		cust1.setCno(500);
		cust1.setCname("Prakash");
		cust1.setBillamt(5000d);
		
		Customer cust2 = new Customer();
		
		cust2.setCno(890);
		cust2.setCname("Rahul");
		cust2.setBillamt(8956254d);
		
		return new ResponseEntity<List<Customer>>(List.of(cust1, cust2), HttpStatus.OK);
	}
}
