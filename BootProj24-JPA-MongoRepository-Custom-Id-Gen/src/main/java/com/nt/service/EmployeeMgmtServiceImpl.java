package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nt.document.Employee;
import com.nt.repository.IEmployeeRepo;


@Service
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService 
{
	@Autowired
	private IEmployeeRepo empRepo;
	
	@Override
	public String saveEmployee(Employee e) 
	{
		return "Employee saved with id : " + empRepo.insert(e).getId();
	}
}
