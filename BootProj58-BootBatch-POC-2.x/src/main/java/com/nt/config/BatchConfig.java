package com.nt.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.nt.listener.JobListener;
import com.nt.processor.CourseProcessor;
import com.nt.reader.CourseReader;
import com.nt.writer.CourseWriter;


@Configuration
@EnableBatchProcessing
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
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Bean
	public Step createStep()
	{
		System.out.println("BatchConfig.createStep()");
		
		return stepBuilderFactory.get("step1")
				.<String, String>chunk(2)
				.reader(reader)
				.processor(processor)
				.writer(writer)
				.build();
	}
	
	@Bean
	public Job createJob(JobRepository repository, Step step)
	{
		System.out.println("BatchConfig.createJob()");
		
		return jobBuilderFactory.get("job1")
				.listener(listener)
				.incrementer(new RunIdIncrementer())
				.start(step)
				.build();
	}
}
