package com.nt.runner;

import java.util.Optional;
import java.util.Random;
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
		e.setEno(200);
		e.setEname("Rahul");
		e.setEadd("Nashik");
		e.setSalary(50000d);
		e.setVaccinated(true);
		
		
		Employee e1 = new Employee();
		e1.setEno(new Random(1000).nextInt());
		e1.setEname("Amol");
		e1.setEadd("Mumbai");
		e1.setSalary(70000d);
		e1.setVaccinated(false);
		
	    //System.out.println(service.saveEmployee(e));
		
		/******************************************/
		/*
		Optional<Employee> emp = service.getEmployeeById(200);
		
		if (emp.isPresent())
		{
			System.out.println(emp.get());
		}
		else 
		{
			System.out.println("Employee not found");
		}
		*/
		
		/******************************************/
        
	    System.out.println(service.getEmployeeByName("Amol"));

	}

}
