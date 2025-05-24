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
public class BootProj04LayeredAppMySqlApplication {

	@Autowired
	private Environment env;
	
	@Bean
	public ComboPooledDataSource createC3PODS() throws Exception
	{
		ComboPooledDataSource datasource = new ComboPooledDataSource();
		
		datasource.setDriverClass(env.getRequiredProperty("spring.datasource.driver-class-name"));
		datasource.setJdbcUrl(env.getRequiredProperty("spring.datasource.url"));
		datasource.setUser(env.getRequiredProperty("spring.datasource.username"));
		datasource.setPassword(env.getRequiredProperty("spring.datasource.password"));
		
		return datasource;
	}
	
	public static void main(String[] args) 
	{
		ConfigurableApplicationContext context = SpringApplication.run(BootProj04LayeredAppMySqlApplication.class, args);
				
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
