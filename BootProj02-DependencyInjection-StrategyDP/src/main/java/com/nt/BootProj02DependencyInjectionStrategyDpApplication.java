package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.sbean.Vehical;

@SpringBootApplication
public class BootProj02DependencyInjectionStrategyDpApplication 
{

	public static void main(String[] args) 
	{
		// Get IOC container
		ConfigurableApplicationContext ctx = SpringApplication.run(BootProj02DependencyInjectionStrategyDpApplication.class, args);
	
		// Get Bean
		Vehical vehical = ctx.getBean("vehical", Vehical.class);
		
		vehical.Journey("Nasik", "Patoda");
		
		// close IOC container
		ctx.close();
	}
	
	/*
	 * OutPut
	 
		CNGEngine - 0 Param Constuctor
		DiaselEngine - 0 Param Constuctor
		PetrolEngine - 0 Param Constuctor
		CNGEngine.start()
		Journey started at - Nasik
		Journey is going on...
		CNGEngine.stop()
		Journey stopped at - Patoda	
	 *
	 */

}
