package com.nt.runner;

import java.util.List;

import org.springframework.asm.TypeReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nt.model.Actor;

@Component
public class ActorReciveingJsonDataCLR5 implements CommandLineRunner 
{
	@Override
	public void run(String... args) throws Exception 
	{
		// Create RestTemplate
		RestTemplate restTemplate = new RestTemplate();
		
		// Define URL
		String url =  "http://localhost:4050/rest-temp-prov/actor-api/reportAll";
		
		// make http request call in get mode
		//ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
		
		// invoke service method/operation using exchange method
		ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, String.class);

		System.out.println("Response Body (GET) : " + responseEntity.getBody());
		System.out.println("Response Status Code : " + responseEntity.getStatusCode().value());
		
		System.out.println("==========================================================");
		
		// Converting JSON Text response to  Java Class obj
		String 			json_body 	= responseEntity.getBody();
		ObjectMapper 	mapper 		= new ObjectMapper();
		List<Actor>		actorList	= mapper.readValue(json_body, List.class);
		
		System.out.println("Response body as Actors Object Data :: " +  actorList);
	}

}
