package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.beans.Employee;

@SpringBootApplication
public class BootProj07ConfigurationPropertiesUsingYmlApplication
{

	public static void main(String[] args)
	{
		ConfigurableApplicationContext ctx = SpringApplication.run(BootProj07ConfigurationPropertiesUsingYmlApplication.class, args);
		
		Employee employee = ctx.getBean("emp", Employee.class);
		
		System.out.println(employee);
		
		ctx.close();
	}
}
