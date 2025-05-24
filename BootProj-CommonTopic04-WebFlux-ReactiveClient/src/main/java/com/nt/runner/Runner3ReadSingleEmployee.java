package com.nt.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import com.nt.model.Employee;
import reactor.core.publisher.Mono;

//@Component
public class Runner3ReadSingleEmployee implements CommandLineRunner
{
	@Override
	public void run(String... args) throws Exception
	{
		// Create Web Client
		WebClient	webClient	=	WebClient.create("http://localhost:4080");
		
		// call GET API
		Mono<Employee> mono =	webClient
									.get()
									.uri("/employee/find/68021d22a987c004c1b80261")
									.retrieve()
									.bodyToMono(Employee.class);
		
		mono.subscribe(System.out::println);		
	}

}
