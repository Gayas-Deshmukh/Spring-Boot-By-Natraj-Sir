package com.nt.runner;

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
		/*
		Employee e = new Employee();
		e.setEno("100");
		e.setEname("Rahul");
		e.setEadd("Nashik");
		e.setSalary(50000d);
		e.setVaccinated(true);
		
		Employee e1 = new Employee();
		e1.setEno("300");
		e1.setEname("Amol");
		e1.setEadd("Mumbai");
		e1.setSalary(70000d);
		e1.setVaccinated(false);
		
		System.out.println(service.saveEmployee(e1));
		*/
		
		/*****************************************************/
		
		//service.getAllEmployees().forEach(System.out :: println);
		
		/*****************************************************/

		//System.out.println(service.searchEmployeeById("671078ab597939564eb8103f"));
		
		/*****************************************************/

		//System.out.println(service.modifyEmployeeById("671075c6decc3c23f7b228ee", 640000d));
		
		/*****************************************************/

		//System.out.println(service.deleteEmployeeById("671142c5128a1662dfb06d98"));
		
		/*****************************************************/
		
		//service.getAllEmployees(false, "ename").forEach(System.out :: println);
		service.getAllEmployees(true, "salary").forEach(System.out :: println);

	}

}
