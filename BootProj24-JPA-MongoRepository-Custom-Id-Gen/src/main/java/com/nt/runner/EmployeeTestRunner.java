package com.nt.runner;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.document.Employee;
import com.nt.service.IEmployeeMgmtService;

@Component
public class EmployeeTestRunner implements CommandLineRunner 
{
	@Autowired
	private IEmployeeMgmtService service;
	
	@Override
	public void run(String... args) throws Exception 
	{
		
		Employee e = new Employee();
		e.setId(UUID.randomUUID().toString());
		e.setEno("200");
		e.setEname("Rahul");
		e.setEadd("Nashik");
		e.setSalary(50000d);
		e.setVaccinated(true);
		
		/*
		Employee e1 = new Employee();
		e1.setId(UUID.randomUUID().toString());
		e1.setEno("100");
		e1.setEname("Amol");
		e1.setEadd("Mumbai");
		e1.setSalary(70000d);
		e1.setVaccinated(false);
		*/
		
		System.out.println(service.saveEmployee(e));
	}

}
