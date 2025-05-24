package com.nt.runner;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import com.nt.entity.Doctor;
import com.nt.service.IDoctorManagementService;


@Component
public class CallingMySQLProcedureTestRunner implements CommandLineRunner 
{
	@Autowired
	private IDoctorManagementService doctorService;
	
	@Override
	public void run(String... args) throws Exception 
	{
		doctorService.getDoctorsByIncome(23000d, 29000d).forEach(System.out::println);			
	}
}
