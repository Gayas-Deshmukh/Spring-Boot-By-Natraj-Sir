package com.nt.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import com.nt.model.Employee;
import reactor.core.publisher.Mono;

//@Component
public class Runner1SaveEmployee implements CommandLineRunner
{
	@Override
	public void run(String... args) throws Exception
	{
		// Create Web Client
		WebClient	webClient	=	WebClient.create("http://localhost:4080");
		
		// call POST API
		Mono<Employee> mono =	webClient
									.post()
									.uri("/employee/save")
									.body(Mono.just(new Employee("10", "Nitin", "Mechanical", 25000d)), Employee.class)
									.retrieve()
									.bodyToMono(Employee.class);
		
		mono.subscribe(System.out :: println);
	}

}
