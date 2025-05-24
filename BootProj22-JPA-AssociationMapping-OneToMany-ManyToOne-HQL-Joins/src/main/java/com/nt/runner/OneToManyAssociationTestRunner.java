package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.OneToManyAssociationMgmtService;

@Component
public class OneToManyAssociationTestRunner implements CommandLineRunner
{
	@Autowired
	private OneToManyAssociationMgmtService service;

	@Override
	public void run(String... args) throws Exception 
	{
		// Parent to child Query
		/*
		service.fetchDataUsingJoinsByParent().forEach(row ->{
			for(Object ob : row)
			{
				System.out.print(ob + " ");
			}
			
			System.out.println();
		});
		*/
		
		/**********************************************************************/
		
		// Child to parent Query
		service.fetchDataUsingJoinsByChild().forEach(row ->{
			for(Object ob : row)
			{
				System.out.print(ob + " ");
			}
			
			System.out.println();
		});
	}
}
