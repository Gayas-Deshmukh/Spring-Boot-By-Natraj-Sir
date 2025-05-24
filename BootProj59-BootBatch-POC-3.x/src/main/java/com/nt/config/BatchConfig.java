package com.nt.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import com.nt.listener.JobListener;
import com.nt.processor.CourseProcessor;
import com.nt.reader.CourseReader;
import com.nt.writer.CourseWriter;


@Configuration
public class BatchConfig 
{
	@Autowired
	private CourseReader reader;
	
	@Autowired
	private CourseProcessor processor;
	
	@Autowired
	private CourseWriter writer;
	
	@Autowired
	private JobListener listener;
	
	@Bean
	public Step createStep(JobRepository repository, PlatformTransactionManager manager)
	{
		System.out.println("BatchConfig.createStep()");
		
		return new StepBuilder("step1", repository)
				.<String, String>chunk(3, manager)
				.reader(reader)
				.processor(processor)
				.writer(writer)
				.build();
	}
	
	@Bean
	public Job createJob(JobRepository repository, Step step)
	{
		System.out.println("BatchConfig.createJob()");
		
		return new JobBuilder("job1", repository)
				.listener(listener)
				.incrementer(new RunIdIncrementer())
				.start(step)
				.build();
	}
}
