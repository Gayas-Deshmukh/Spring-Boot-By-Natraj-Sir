package com.nt.listener;

import java.util.Date;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component("jmListner")
public class JobListener implements JobExecutionListener
{
	private long startTime, endTime;
	
	@Override
	public void beforeJob(JobExecution jobExecution) 
	{
		System.out.println("Job is about to begain at :: "+ new Date());
		
		startTime=System.currentTimeMillis();
		
		System.out.println("Job Status :: "+ jobExecution.getStatus());
	}
	
	@Override
	public void afterJob(JobExecution jobExecution) 
	{
		System.out.println("Job is completed at :: "+ new Date());

		endTime=System.currentTimeMillis();
		
		System.out.println("Job Execution time :: "+ (endTime - startTime));

		System.out.println("Job Status :: "+ jobExecution.getStatus());
	}
}
