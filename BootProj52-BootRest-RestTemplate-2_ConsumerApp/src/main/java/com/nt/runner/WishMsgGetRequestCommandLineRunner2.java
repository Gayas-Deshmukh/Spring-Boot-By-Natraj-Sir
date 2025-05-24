package com.nt.runner;

import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class WishMsgGetRequestCommandLineRunner2 implements CommandLineRunner 
{

	@Override
	public void run(String... args) throws Exception 
	{
		// Create Rest Template
		RestTemplate restTemplate = new RestTemplate();
		
		// URL: http://localhost:4050/rest-temp-prov/wish-api/wish
		String url =  "http://localhost:4050/rest-temp-prov/wish-api/wish/{name}/{location}";
		
		//ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class, "Raju", "Nagar");
		//ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class, Map.of("location", "Pune", "name", "Amol"));

		// invoke service method/operation using exchange method
		ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, String.class, "Dipak", "Mumbai");

		System.out.println("Response Body : " + responseEntity.getBody());
		System.out.println("Response Status Code : " + responseEntity.getStatusCode().value());
		
		System.out.println("==========================================================");
	}

}
