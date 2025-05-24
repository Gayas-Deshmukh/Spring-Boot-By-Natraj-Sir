package com.nt.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class ActorPostingJsonDataCLR3 implements CommandLineRunner 
{
	@Override
	public void run(String... args) throws Exception 
	{
		// Create RestTemplate
		RestTemplate restTemplate = new RestTemplate();
		
		// Define URL
		String url =  "http://localhost:4050/rest-temp-prov/actor-api/register";
		
		// prepare JSON data (request body)
		String json_body = "{\"aid\":433,\"name\":\"Ganesh\",\"age\":25,\"type\":\"hero\"}";
		
		// prepare headers
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		//prepare http request as HttpEntity obj having head, body
		HttpEntity<String> request = new HttpEntity<String>(json_body, headers);
		
		// make http request call in post mode
		//ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, request, String.class);
		
		// invoke service method/operation using exchange method
		ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, request, String.class);

		System.out.println("Response Body (POST) : " + responseEntity.getBody());
		System.out.println("Response Status Code : " + responseEntity.getStatusCode().value());
		
		System.out.println("==========================================================");
	}

}
