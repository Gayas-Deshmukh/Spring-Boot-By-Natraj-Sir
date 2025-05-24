package com.nt.service;

import java.util.List;
import com.nt.entity.Employee;

public interface IEmployeeManagementService
{
	public Employee saveEmployee(Employee empl);
	public List<Employee> getAllEmpployes();
	public Double getEmployeeAge(String name);
}
