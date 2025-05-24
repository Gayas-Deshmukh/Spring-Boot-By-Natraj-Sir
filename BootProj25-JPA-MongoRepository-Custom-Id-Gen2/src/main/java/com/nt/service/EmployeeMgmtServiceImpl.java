package com.nt.service;

import java.util.Optional;

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
		return "Employee saved with id : " + empRepo.insert(e).getEno();
	}

	@Override
	public Optional<Employee> getEmployeeById(Integer id)
	{
		return empRepo.findById(id);
	}

	@Override
	public Employee getEmployeeByName(String name)
	{
		return empRepo.findByEname(name);
	}
	
	
}
