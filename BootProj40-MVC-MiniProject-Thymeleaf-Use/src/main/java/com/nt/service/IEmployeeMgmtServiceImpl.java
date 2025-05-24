package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nt.model.Employee;
import com.nt.repo.IEmployeeRepository;

@Service
public class IEmployeeMgmtServiceImpl  implements IEmployeeMgmtService
{
	@Autowired
	private IEmployeeRepository emplRepo;

	@Override
	public Iterable<Employee> getEmployee() 
	{
		return emplRepo.findAll();
	}

	@Override
	public String registerEmployee(Employee emp) 
	{
		return "Employee saved with id : "+ emplRepo.save(emp).getEmpno();
	}

	@Override
	public Employee getEmployeeByNo(int no)
	{
		return emplRepo.findById(no).orElseThrow(() ->  new IllegalArgumentException());
	}

	@Override
	public String updateEmployee(Employee emp)
	{
		return "Employee is updated having empid : "+ emplRepo.save(emp).getEmpno();
	}

	@Override
	public String deleteEmployeeById(int id) 
	{
		emplRepo.deleteById(id);
		return "Employee with id " + id + " is deleted";
	}
}
