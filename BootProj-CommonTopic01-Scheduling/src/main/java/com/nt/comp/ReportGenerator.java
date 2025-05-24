package com.nt.comp;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("reportGen")
public class ReportGenerator 
{
	/*
	//@Scheduled(initialDelay = 3000, fixedDelay = 5000)
	@Scheduled(initialDelay = 3000, fixedRate = 5000)
	public void generateReport()
	{
		System.out.println("Generated Report on : " + new Date());
		
		try 
		{
			Thread.sleep(10000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		System.out.println("---------------------------");
	}
	*/

	//@Scheduled(cron = "2 * * * * *")
	//@Scheduled(cron = "0 42 17 * * *")
	//@Scheduled(cron = "* 47 17 * * *")
	@Scheduled(cron = "0 10 14 * * SAT")
	public void generateReport()
	{
		System.out.println("Generated Report on : " + new Date());
		System.out.println("Thread -" + Thread.currentThread().getName());
		System.out.println("---------------------------");
	}
}
