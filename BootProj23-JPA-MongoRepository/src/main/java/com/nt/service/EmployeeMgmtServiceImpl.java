package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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

	@Override
	public List<Employee> getAllEmployees() 
	{
		return empRepo.findAll();
	}

	@Override
	public String searchEmployeeById(String id) 
	{
		Optional<Employee> optional = empRepo.findById(id);
		
		if (optional.isPresent())
		{
			return optional.get().toString();
		}
		else
		{
			return "Employee with given id " + id + " is not found";
		}
	}

	@Override
	public String modifyEmployeeById(String id, Double salary) 
	{
		Optional<Employee> optional = empRepo.findById(id);
		
		if (optional.isPresent())
		{
			Employee emp = optional.get();
			
			emp.setSalary(salary);
			empRepo.save(emp);
			
			return "Employee salary has been updated";
		}
		else
		{
			return "Employee with given id " + id + " is not found";
		}
	}

	@Override
	public String deleteEmployeeById(String id) 
	{
        Optional<Employee> optional = empRepo.findById(id);
		
		if (optional.isPresent())
		{
			empRepo.deleteById(id);
			
			return "Employee salary has been deleted";
		}
		else
		{
			return "Employee with given id " + id + " is not found";
		}
	}

	@Override
	public List<Employee> getAllEmployees(boolean asc, String... properties) 
	{
        Sort sort = Sort.by(asc ? Direction.ASC : Direction.DESC, properties);
        
		return empRepo.findAll(sort);
	}
	
	
}
