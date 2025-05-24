package com.nt.runner;

import java.time.LocalDate;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.document.DrivingLicence;
import com.nt.document.Person;
import com.nt.service.IRTOMgmtService;

@Component
public class TestRunner implements CommandLineRunner
{
	@Autowired
	private IRTOMgmtService service;

	@Override
	public void run(String... args) throws Exception 
	{
		/*
		// create parent obj
		Person person = new Person();
		person.setPid(new Random().nextInt());
		person.setName("Rahul");
		person.setAddrs("Nashik");
		
		// create child obj
		DrivingLicence licence = new DrivingLicence();
		licence.setLicenceNo(new Random(1000).nextLong());
		licence.setType("LW");
		licence.setExpiryDate(LocalDate.of(2029, 03, 15));
		
		person.setLicence(licence);
		
		System.out.println(service.registerPersonWithDrivingLicence(person));
		*/
		
		/**********************************************************/
		
		// create child obj
		DrivingLicence licence = new DrivingLicence();
		licence.setLicenceNo(new Random(1000).nextLong());
		licence.setType("HV");
		licence.setExpiryDate(LocalDate.of(2030, 05, 15));
		
		// create parent obj
		Person person = new Person();
		person.setPid(new Random().nextInt());
		person.setName("Hrushi");
		person.setAddrs("Pune");
		
		licence.setPersonDetails(person);
		
		//System.out.println(service.registerDrivingLicenceWithPerson(licence));
		
		/**********************************************************/

		service.fetchAllPersonDetails().forEach(per -> {
			System.out.println("Parent ::" + per );
			System.out.println("Child ::" + per.getLicence());
		});
		
		/**********************************************************/

		service.fetchAllLicenceDetails().forEach(lic -> {
			System.out.println("Child ::" + lic );
			System.out.println("Parent ::" + lic.getPersonDetails());
		});
	}

}
