package com.nt.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import com.nt.model.Employee;
import reactor.core.publisher.Flux;


//@Component
public class Runner2ReadAllEmployees implements CommandLineRunner
{

	@Override
	public void run(String... args) throws Exception
	{
		// Create Web Client
		WebClient	webClient	=	WebClient.create("http://localhost:4080");
		
		// call GET API
		Flux<Employee> flux =	webClient
									.get()
									.uri("/employee/all")
									.retrieve()
									.bodyToFlux(Employee.class);
		
		flux.doOnNext(System.out::println).blockLast();
	}

}
