package com.nt.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.nt.entity.Doctor;
import com.nt.service.IDoctorService;

@Component
public class JpaTestRunner implements CommandLineRunner 
{
	@Autowired
	private IDoctorService doctorService;
	
	@Override
	public void run(String... args) throws Exception 
	{
		//System.out.println(doctorService.deleteDoctorsByIdsInBatch(Arrays.asList(56,57, 100)));
		
		/*************************************************/
		/*
		Doctor doctor	= Doctor.builder()
								.docName("Shantaram")
								.income(25000d)
								.build();
		
		List<Doctor> docList = doctorService.showDoctorsByExampleData(doctor, false, "docId");
		
		docList.forEach(System.out::println);
		*/
		/*************************************************/
		
		Doctor doctor = doctorService.findDoctorById(54);
				
		System.out.println("Specialization : " + doctor.getSpecialization());
		
	}
}
