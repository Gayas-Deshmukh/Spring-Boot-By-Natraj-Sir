package com.nt;

import java.util.Date;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@SpringBootApplication
public class BootProjCommonTopic01SchedulingApplication 
{

	public static void main(String[] args) 
	{
		System.out.println("App started on :: " + new Date());
		
		SpringApplication.run(BootProjCommonTopic01SchedulingApplication.class, args);
	}

}
