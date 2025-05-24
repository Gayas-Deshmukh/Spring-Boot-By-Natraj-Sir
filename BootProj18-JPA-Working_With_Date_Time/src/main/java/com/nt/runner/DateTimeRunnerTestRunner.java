package com.nt.runner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.nt.entity.Employee;
import com.nt.service.IEmployeeManagementService;


@Component
public class DateTimeRunnerTestRunner implements CommandLineRunner 
{
	@Autowired
	private IEmployeeManagementService employeeMgmtService;
	
	@Override
	public void run(String... args) throws Exception 
	{
		Employee emp = new Employee();
		
		emp.setEname("Rahul");
		emp.setDesg("Developer");
		emp.setDob(LocalDateTime.of(1970, 5, 15, 10, 30));
		emp.setDoj(LocalDate.of(2020, 1, 5));
		emp.setTob(LocalTime.of(11, 15));
		
		Employee emp2 = new Employee();
		
		emp2.setEname("Nitin");
		emp2.setDesg("Tester");
		emp2.setDob(LocalDateTime.of(1998, 4, 14, 8, 30));
		emp2.setDoj(LocalDate.of(2019, 1, 5));
		emp2.setTob(LocalTime.of(12, 15));
		
		//System.out.println(employeeMgmtService.saveEmployee(emp2));
		
		//employeeMgmtService.getAllEmpployes().forEach(System.out::println);
		
		System.out.println("Nitin's Age : " + employeeMgmtService.getEmployeeAge("Nitin"));
		System.out.println("Rahul's Age : " + employeeMgmtService.getEmployeeAge("Rahul"));
	}
}
