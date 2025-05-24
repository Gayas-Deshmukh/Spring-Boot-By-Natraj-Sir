package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.beans.Company;
import com.nt.beans.Organization;

@SpringBootApplication
public class BootProj06ConfigurationPropertiesApplication 
{
	public static void main(String[] args)
	{
		ConfigurableApplicationContext ctx = SpringApplication.run(BootProj06ConfigurationPropertiesApplication.class, args);
		
		Company	company	=	ctx.getBean("company", Company.class);
		
		System.out.println(company);
		
		System.out.println("=================================================");
		
		Organization	organization	=	ctx.getBean("organization", Organization.class);
		
		System.out.println(organization);
		
		ctx.close();
	}
}
