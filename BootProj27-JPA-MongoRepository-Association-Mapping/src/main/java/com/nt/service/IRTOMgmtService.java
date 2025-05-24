package com.nt.service;

import java.util.List;

import com.nt.document.DrivingLicence;
import com.nt.document.Person;

public interface IRTOMgmtService 
{
	public String registerPersonWithDrivingLicence(Person person);
	public String registerDrivingLicenceWithPerson(DrivingLicence licence);
	public List<Person> fetchAllPersonDetails();
	public List<DrivingLicence> fetchAllLicenceDetails();
}
