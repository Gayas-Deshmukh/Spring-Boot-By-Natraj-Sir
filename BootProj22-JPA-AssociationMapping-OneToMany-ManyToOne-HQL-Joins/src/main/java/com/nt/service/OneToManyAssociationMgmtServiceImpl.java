package com.nt.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Person;
import com.nt.entity.PhoneNumber;
import com.nt.repository.IPersonRepository;
import com.nt.repository.IPhoneNuberRepositoy;

@Service
public class OneToManyAssociationMgmtServiceImpl implements OneToManyAssociationMgmtService
{
	@Autowired
	private IPersonRepository personRepo;
	
	@Autowired
	private IPhoneNuberRepositoy phoneNumberRepo;

	@Override
	public List<Object[]> fetchDataUsingJoinsByParent() 
	{
		return personRepo.fetchDataUsingJoinsByParent();
	}

	@Override
	public List<Object[]> fetchDataUsingJoinsByChild() 
	{
		return phoneNumberRepo.fetchDataUsingJoinsByChild();
	}
	
	
	
}
