package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.document.DrivingLicence;
import com.nt.document.Person;
import com.nt.repository.IDrivingLicenceRepository;
import com.nt.repository.IPersonRepository;

@Service
public class RTOMgmtServiceImpl implements IRTOMgmtService 
{
	@Autowired
	private IPersonRepository personRepo;
	
	@Autowired
	private IDrivingLicenceRepository drivingLicenceRepo;
	
	@Override
	public String registerPersonWithDrivingLicence(Person person) 
	{
		return "Person with DrivingLicence is saved with id value ::"+ personRepo.save(person).getPid();
	}

	@Override
	public String registerDrivingLicenceWithPerson(DrivingLicence licence) 
	{		
		return "DrivingLicence with Person is saved with id value ::"+ drivingLicenceRepo.save(licence).getLicenceNo();
	}

	@Override
	public List<Person> fetchAllPersonDetails() 
	{
		return personRepo.findAll();
	}

	@Override
	public List<DrivingLicence> fetchAllLicenceDetails()
	{
		return drivingLicenceRepo.findAll();
	}

}
