package com.nt.runner;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BatchProcessingRunner implements CommandLineRunner
{
	@Autowired
	private JobLauncher launcher;
	
	@Autowired
	private Job job;
	
	@Override
	public void run(String... args) throws Exception 
	{
		JobParameters params = new JobParametersBuilder()
									.addLong("time", System.currentTimeMillis())
									.toJobParameters();
		
		JobExecution jobExecution = launcher.run(job, params);
		
		System.out.println("Press any key to continue?");
		System.in.read();
	}
}
