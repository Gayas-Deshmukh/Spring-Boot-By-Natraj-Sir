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
public class QueryMethodTestRunner implements CommandLineRunner 
{	
	@Autowired
	private IDoctorRepo doctorRepo; 
	
	@Override
	public void run(String... args) throws Exception 
	{
		//doctorRepo.searchDoctorByIncomeRange(23000, 26000).forEach(System.out::println);
		
		/********************************************************/

		//doctorRepo.searchDoctorsBySpecialization("Specialist", "ShreeRogTadnya").forEach(System.out::println);
		
		/********************************************************/

		/*
		List<Object[]> data = doctorRepo.searchDoctorsByIncome(23000, 26000);
		
		data.forEach(row ->{
			for (Object ob : row)
			{
				System.out.print(ob + " ");
			}
			
			System.out.println();
		});
		*/
		
		/********************************************************/

		/*
		List<String>	names	=	doctorRepo.searchAllDoctorsNamesByIncome(23000, 26000);
		
		names.forEach(System.out::println);
		*/
		
		/********************************************************/

		//System.out.println(doctorRepo.showDoctorInfoByName("Chavan"));
		
		/********************************************************/
		
		/*
		Object [] info = (Object [])doctorRepo.showDoctorSomeDataByName("Pravin");

		for(Object ob : info)
		{
			System.out.print(ob + " ");
		}
		*/
		
		/********************************************************/
		
		//System.out.println(doctorRepo.showDoctorSpecialization("Chavan"));
		
		/********************************************************/
 
		/*
		Object objData [] = (Object [])doctorRepo.fetchAggregateData();
		
		System.out.println("Count : " + objData[0]);
		System.out.println("Max : " + objData[1]);
		System.out.println("Min : " + objData[2]);
		System.out.println("Sum : " + objData[3]);
		System.out.println("Avg : " + objData[4]);
		*/

		/********************************************************/
		/*
		int count = doctorRepo.hikeDoctorIncomeBySpecialization("Specialist", 20);
		System.out.println("Updated " + count + " records");
		*/
	
		/********************************************************/
		/*
		int count = doctorRepo.removeDoctorByName("Pravin");
		System.out.println("Deleted " + count + " records");
		*/
		
		/********************************************************/

		/*
		int count = doctorRepo.registorDoctor(59, "Suresh", 28888d, "MD Doc");
		System.out.println("Inserted " + count + " records");
		*/
		
		/********************************************************/
		/*
		System.out.println("SysDate : " + doctorRepo.showSystemDate());
		*/

		/********************************************************/

		int count = doctorRepo.TempTable();
		
		System.out.println((count == 0) ? "db table is created" : "db table is not created");
	}
}
