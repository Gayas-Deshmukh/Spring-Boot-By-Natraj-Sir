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
		//service.saveDataUsingParent();
		//service.saveDataUsingChild();
		
		//service.loadDataUsingParent();
		//service.loadDataUsingChild();
		
		//service.deleteDataUsingParent(101);
		//service.deleteDataUsingChild(153);	
		//service.deleteAllPhoneNumbersOfPerson(104);
		
		service.addNewChildToExistingParent(100);
	}
}
