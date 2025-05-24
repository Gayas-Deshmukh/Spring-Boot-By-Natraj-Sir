package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Employee;
import com.nt.service.IEmployeeService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employee")
public class EmployeeController 
{
	@Autowired
	private IEmployeeService service;
	
	@PostMapping("/save")
	public Mono<Employee> saveEmployee(@RequestBody Employee emp)
	{
		return service.saveEmployee(emp);
	}
	
	@GetMapping("/all")
	public Flux<Employee> allEmployee()
	{
		return service.findAllEmployees();
	}
	
	@GetMapping("/find/{Id}")
	public Mono<Employee> getEmployeeById(@PathVariable("Id") String id)
	{
		try
		{
			System.out.println("Current Thread:" + Thread.currentThread().getName());
			Thread.sleep(3000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		return service.getEmployeeById(id);
	}
	
	@DeleteMapping("/delete/{Id}")
	public Mono<Void> deleteEmployee(@PathVariable("Id") String id)
	{
		return service.deleteEmployee(id);
	}
}
