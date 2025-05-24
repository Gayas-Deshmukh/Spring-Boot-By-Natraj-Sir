package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.beans.Hotel;

@SpringBootApplication
public class BootProj05ValueAnnotationSpelApplication 
{

	public static void main(String[] args) 
	{
		ConfigurableApplicationContext ctx = SpringApplication.run(BootProj05ValueAnnotationSpelApplication.class, args);
		
		Hotel hotel = ctx.getBean("hotel", Hotel.class);
		
		System.out.println(hotel);
		
		ctx.close();
	}

}
