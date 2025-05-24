package com.nt.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import com.nt.entity.Doctor;
import com.nt.repository.IDoctorRepo;

@Component
public class CustomFinderMethodTestRunner implements CommandLineRunner 
{	
	@Autowired
	private IDoctorRepo doctorRepo; 
	
	@Override
	public void run(String... args) throws Exception 
	{
		//doctorRepo.findByDocNameEquals("chavan").forEach(System.out::println);
		
		//doctorRepo.findByDocNameIs("chavan").forEach(System.out::println);

		//doctorRepo.findByDocName("chavan").forEach(System.out::println);

		//doctorRepo.getBySpecializationStartingWith("s").forEach(System.out::println);

		//doctorRepo.getBySpecializationEndingWith("t").forEach(System.out::println);

		//doctorRepo.getBySpecializationContaining("d").forEach(System.out::println);
		
		//doctorRepo.getBySpecializationContaining("d").forEach(System.out::println);

		//doctorRepo.getByIncomeIsNull().forEach(System.out::println);
		
		//doctorRepo.getByDocNameOrderByIncomeDesc("shantaram").forEach(System.out::println);

		//doctorRepo.getByDocNameLike("%cha%").forEach(System.out::println);

		//doctorRepo.getByDocNameLike("%ram").forEach(System.out::println);
		
		doctorRepo.getByDocNameLike("___vin").forEach(System.out::println);


	}
}
