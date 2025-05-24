package com.nt.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nt.model.Employee;

public interface IEmployeeMgmtService 
{
	Page<Employee> getEmployeeByPage(Pageable pageable);
	String registerEmployee(Employee emp);
	Employee getEmployeeByNo(int no);
	String updateEmployee(Employee emp);
	String deleteEmployeeById(int id);
}
