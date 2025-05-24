package com.nt;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.nt.sbeans.SeasonFinder;

@SpringBootApplication
public class BootProj01DependencyInjectionApplication 
{

	public static void main(String[] args) 
	{
		// Get IOC container
		ApplicationContext ctx = SpringApplication.run(BootProj01DependencyInjectionApplication.class, args);
		
		// Get Target spring class obj 
		SeasonFinder seasonFinder = ctx.getBean("sf", SeasonFinder.class);
		
		String season = seasonFinder.findSession();
		System.out.println("Season Name :: " + season);
		
		// close the IOC container
		((ConfigurableApplicationContext)ctx).close();
	}

	@Bean(name = "ld")
	public LocalDate createDate()
	{
		return LocalDate.now();
	}
}
