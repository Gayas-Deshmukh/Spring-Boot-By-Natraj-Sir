package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Doctor;
import com.nt.service.IDoctorService;

@Component
public class DoctorTestReunner implements CommandLineRunner 
{
	@Autowired
	private IDoctorService doctorService;
	
	@Override
	public void run(String... args) throws Exception 
	{   
		/** Insert operation**/
		/*
		Doctor doctor1 = new Doctor();
		doctor1.setDocName("Shantaram");
		doctor1.setSpecialization("ShreeRogTadnya");
		doctor1.setIncome(25000d);
		
		Doctor doctor2 = new Doctor();
		doctor2.setDocName("Pravin");
		doctor2.setSpecialization("Md Doctor");
		doctor2.setIncome(25000d);
		
		Doctor doctor3 = new Doctor();
		doctor3.setDocName("Chavhan");
		doctor3.setSpecialization("Speshalist");
		doctor3.setIncome(25000d);
		
		String msg1 = doctorService.registerDoctor(doctor1);
		System.out.println(msg1);
		
		String msg2 = doctorService.registerDoctor(doctor2);
		System.out.println(msg2);
		
		String msg3 = doctorService.registerDoctor(doctor3);
		System.out.println(msg3);
		*/
		
		/** Fetch **/
		//System.out.println(doctorService.getDoctorById(52));
		//System.out.println(doctorService.getDoctorById(200)); // invalid id
		
		//int id = 52;
		//System.out.println("Is doctor exits with id :" + id + " ? - " + doctorService.isDoctorExistsById(id));
		
		//System.out.println("All Docs count : " + doctorService.getDoctorsCount());
		
		//Iterable<Doctor> allDoctord = doctorService.getAllDoctord(List.of(52, 53));
		
		//allDoctord.forEach(System.out::print);
		
		/** Delete **/
		String msg	= doctorService.deleteDoctorById(54);
		
		System.out.println(msg);
	}
}
