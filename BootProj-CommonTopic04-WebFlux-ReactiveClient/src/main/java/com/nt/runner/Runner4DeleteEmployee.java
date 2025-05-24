package com.nt.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Component
public class Runner4DeleteEmployee implements CommandLineRunner
{
	@Override
	public void run(String... args) throws Exception
	{
		// Create Web Client
		WebClient	webClient	=	WebClient.create("http://localhost:4080");
		
		// call DELETE API
		Mono<Void> mono =	webClient
									.delete()
									.uri("/employee/delete/10")
									.retrieve()
									.bodyToMono(Void.class);
		
		mono.subscribe(System.out::println);
		System.out.println("Deleted!");
	}
}
