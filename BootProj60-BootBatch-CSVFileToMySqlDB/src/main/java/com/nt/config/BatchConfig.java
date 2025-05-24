package com.nt.config;

import javax.sql.DataSource;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.data.builder.RepositoryItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;
import com.nt.listener.JobListener;
import com.nt.model.Employee;
import com.nt.processor.EmployeeItemProcessor;
import com.nt.repo.IEmployeeRepo;


@Configuration
public class BatchConfig 
{
	@Autowired
	private JobListener listener;
	
	@Autowired
	private EmployeeItemProcessor processor;
	
	@Autowired
	private IEmployeeRepo emRepo;
	
	@Bean
	public FlatFileItemReader<Employee> createReader()
	{
		System.out.println("BatchConfig.createReader()");
		
		return new FlatFileItemReaderBuilder<Employee>()
				.name("file-reader")
				.resource(new ClassPathResource("Employee_Info.csv"))
				.delimited()
				.names("empno", "empname", "empadds", "salary")
				.targetType(Employee.class)
				.build();
	}
	
	@Bean
	public RepositoryItemWriter<Employee> createWriter()
	{
		System.out.println("BatchConfig.createWriter()");
		
		return new RepositoryItemWriterBuilder<Employee>()
				.repository(emRepo)
				.methodName("save")
				.build();
	}
	
	@Bean
	public Step createStep(JobRepository jobRepository, PlatformTransactionManager manager)
	{
		System.out.println("BatchConfig.createStep()");
		
		return new StepBuilder("step1", jobRepository)
				.<Employee, Employee>chunk(5, manager)
				.reader(createReader())
				.processor(processor)
				.writer(createWriter())
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
