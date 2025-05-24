package com.nt.runner;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
public class TestRunner1 implements CommandLineRunner 
{
	@Override
	public void run(String... args) throws Exception 
	{
		System.out.println("CommandLineRunner : " + Arrays.toString(args)); 
	}
}
