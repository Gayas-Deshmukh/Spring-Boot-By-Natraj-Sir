package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.nt.sbean.Vehical;

@SpringBootApplication
@ImportResource("classpath:com/nt/cfgs/applicationContext.xml")
public class BootProj03DependencyInjectionStrategyDpApplication 
{
	public static void main(String[] args) 
	{
		// Get IOC container
		ConfigurableApplicationContext ctx = SpringApplication.run(BootProj03DependencyInjectionStrategyDpApplication.class, args);
	
		// Get Bean
		Vehical vehical = ctx.getBean("vehical", Vehical.class);
		
		vehical.Journey("Nasik", "Patoda");
		
		// close IOC container
		ctx.close();
	}
	
	/**Output
	 * 
	 * 
	 * CNGEngine - 0 Param Constuctor
		DiaselEngine - 0 Param Constuctor
		PetrolEngine - 0 Param Constuctor
		DiaselEngine.start()
		Journey started at - Nasik
		Journey is going on...
		DiaselEngine.stop()
		Journey stopped at - Patoda
	 */
}
