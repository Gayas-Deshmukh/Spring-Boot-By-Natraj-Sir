package com.nt.service;

import com.nt.model.Employee;

public interface IEmployeeMgmtService 
{
	Iterable<Employee> getEmployee();
	String registerEmployee(Employee emp);
	Employee getEmployeeByNo(int no);
	String updateEmployee(Employee emp);
	String deleteEmployeeById(int id);
}
