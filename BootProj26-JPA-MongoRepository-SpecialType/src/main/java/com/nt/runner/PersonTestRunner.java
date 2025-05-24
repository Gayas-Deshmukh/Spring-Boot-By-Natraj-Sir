package com.nt.runner;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.document.Person;
import com.nt.service.IPersonMgmtService;

@Component
public class PersonTestRunner implements CommandLineRunner 
{
	@Autowired
	private IPersonMgmtService personService;
	
	@Override
	public void run(String... args) throws Exception 
	{
		Person person = new Person();
		
		person.setPId(new Random(1000).nextInt());
		person.setPname("Rahul");
		person.setSimcards(new String [] {"VI", "Jio"});
		person.setNickNames(List.of("Bagga", "Tintu"));
		person.setContactNos(Set.of(55869378l, 63985244l));
		person.setBikeswithPrice(Map.of("Unicorn", "Nashik", "HF-Delux", "Patoda"));
		
		Properties prop = new Properties();
		
		prop.put("Adhar", 258741258);
		prop.put("Pan", 87412589);
		
		person.setIdDetails(prop);
		
		System.out.println(personService.registerPerson(person));
	}

}
