package com.nt.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class TestRunner2 implements ApplicationRunner 
{
	@Override
	public void run(ApplicationArguments args) throws Exception 
	{
		System.out.println("Application Runner : " + args.getNonOptionArgs());
		
		System.out.println("=================================");
		
		for (String name : args.getOptionNames())
		{
			System.out.println(name + " ->" + args.getOptionValues(name));
		}
		
	}
}
