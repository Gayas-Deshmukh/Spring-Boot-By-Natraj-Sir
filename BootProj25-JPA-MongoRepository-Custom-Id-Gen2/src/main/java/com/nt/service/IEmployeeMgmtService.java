package com.nt.service;

import java.util.Optional;

import com.nt.document.Employee;

public interface IEmployeeMgmtService 
{
	public String saveEmployee(Employee e);
	public Optional<Employee> getEmployeeById(Integer id);
	public Employee getEmployeeByName(String name);

}
