package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.nt.entity.Doctor;
import com.nt.service.IDoctorService;

@Component
public class PaggingAndSortingTestReunner implements CommandLineRunner 
{
	@Autowired
	private IDoctorService doctorService;
	
	@Override
	public void run(String... args) throws Exception 
	{   
		/** Use of Sort**/
		//Iterable<Doctor> it = doctorService.showDoctorBySorting(false, "income", "docName");	
		//it.forEach(System.out::println);
		
		/**Use of Sort & Pagination**/
		/*
		Page<Doctor> page = doctorService.showDoctorInfoByPageNo(1, 2, true, "docName");
		
		System.out.println("Page No : " + (page.getNumber() + 1));
		System.out.println("Total Pages : " + page.getTotalPages());
		System.out.println("Is First Page :" + page.isFirst());
		System.out.println("Is Last Page :" + page.isLast());
		System.out.println("Page Size :" + page.getSize());
		System.out.println("Total Elements :" + page.getTotalElements());
		
		List<Doctor> docList = page.toList();	
		docList.forEach(System.out::println);
		*/
		/* OutPut
		Page No : 2
		Total Pages : 2
		Is First Page :false
		Is Last Page :true
		Page Size :2
		Total Elements :4
		Doctor(docId=52, docName=Shantaram, specialization=ShreeRogTadnya, income=25000.0)
		Doctor(docId=55, docName=Shantaram, specialization=Bone Specialist, income=25000.0)
		 */
		
		doctorService.showDataThroughtPagination(3);
	}
}
