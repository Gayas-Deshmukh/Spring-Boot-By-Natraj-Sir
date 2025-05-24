package com.nt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.nt.controller.PayrollOperationsController;
import com.nt.model.Employee;

@SpringBootApplication()
public class BootProj09LayeredAppProfilesMultipleYMLFiles 
{
	public static void main(String[] args) 
	{
		ConfigurableApplicationContext context = SpringApplication.run(BootProj09LayeredAppProfilesMultipleYMLFiles.class, args);
				
		PayrollOperationsController payrollOperationsController = context.getBean("payroll", PayrollOperationsController.class);
		
		try 
		{
			List<Employee> empList = payrollOperationsController.showEmplyoeesByDesg("CLERK", "MANAGER", "SALESMAN");
			
			empList.forEach(emp -> {
				System.out.println(emp);
			});
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("Internal Error " + e.getMessage());
		}
		finally 
		{
			context.close();
		}
	}

}
