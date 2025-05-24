package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.nt.entity.Employee;
import com.nt.repository.IEmployeeRepository;

@Service
public class EmployeeManagementServiceImpl implements IEmployeeManagementService
{
	@Autowired
	private IEmployeeRepository employeeRepo;

	@Override
	public Employee saveEmployee(Employee empl) 
	{
		return employeeRepo.save(empl);
	}

	@Override
	public List<Employee> getAllEmpployes() 
	{
		return employeeRepo.findAll();
	}

	@Override
	public Double getEmployeeAge(String name) 
	{
		return employeeRepo.getEmplyeeAgeByName(name);
	}
	

}
