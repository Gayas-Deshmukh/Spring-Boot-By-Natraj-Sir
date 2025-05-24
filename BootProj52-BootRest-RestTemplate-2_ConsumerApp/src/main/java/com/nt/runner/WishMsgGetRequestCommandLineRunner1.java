package com.nt.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class WishMsgGetRequestCommandLineRunner1 implements CommandLineRunner 
{

	@Override
	public void run(String... args) throws Exception 
	{
		// Create rest template
		RestTemplate restTemplate = new RestTemplate();
		
		// Define URL: http://localhost:4050/rest-temp-prov/wish-api/wish
		String url =  "http://localhost:4050/rest-temp-prov/wish-api/wish";
		
		// make service request call
		//ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
		
		// invoke service method/operation using exchange method
		ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, String.class);

		System.out.println("Response Body : " + responseEntity.getBody());
		System.out.println("Response Status Code : " + responseEntity.getStatusCode().value());
		
		System.out.println("==========================================================");
	}

}
