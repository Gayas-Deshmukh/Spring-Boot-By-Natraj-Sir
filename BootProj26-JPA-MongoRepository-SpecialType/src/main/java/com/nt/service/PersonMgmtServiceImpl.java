package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.document.Person;
import com.nt.repository.IPersonRepo;

@Service
public class PersonMgmtServiceImpl implements IPersonMgmtService
{
	@Autowired
	private IPersonRepo personRepo;
	
	@Override
	public String registerPerson(Person per) 
	{
		return "Person is saved with id value :" + personRepo.insert(per).getPId();
	}
}
