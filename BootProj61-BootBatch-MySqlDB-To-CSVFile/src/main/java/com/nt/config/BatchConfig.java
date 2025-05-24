package com.nt.config;

import javax.sql.DataSource;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;
import com.nt.listener.JobListener;
import com.nt.model.ExamResult;
import com.nt.processor.ExamResultItemProcessor;


@Configuration
public class BatchConfig 
{
	@Autowired
	private JobListener listener;
	
	@Autowired
	private ExamResultItemProcessor processor;
	
	@Autowired
	private DataSource ds;
	
	// Reader
	@Bean
	public JdbcCursorItemReader<ExamResult> createReader() 
	{
		System.out.println("BatchConfig.createReader()");
		
		return new JdbcCursorItemReaderBuilder<ExamResult>()
					.name("jdbc-reader")
					.dataSource(ds)
					.sql("SELECT ID, DOB, SEMISTER, PERCENTAGE FROM EXAM_RESULT")
					.beanRowMapper(ExamResult.class)
					.build();
	}
	
	// Writer
	@Bean
	public FlatFileItemWriter<ExamResult> createWriter() 
	{
		System.out.println("BatchConfig.createWriter()");
		
		return new FlatFileItemWriterBuilder<ExamResult>()
					.name("writer")
					.resource(new FileSystemResource("TopBrains.csv"))
					.lineSeparator("\r\n")
					.delimited().delimiter(",")
					.names("id", "dob", "percentage", "semister")
					.build();		
	}
	
	// Create Step
	@Bean
	public Step createStep(JobRepository jobRepository, PlatformTransactionManager manager)
	{
		System.out.println("BatchConfig.createStep()");
		
		return new StepBuilder("step1", jobRepository)
				.<ExamResult, ExamResult>chunk(2, manager)
				.reader(createReader())
				.processor(processor)
				.writer(createWriter())
				.build();
	}
	
	// Create Job
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
