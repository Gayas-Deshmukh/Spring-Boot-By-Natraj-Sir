package com.nt.service;

import java.util.List;

import com.nt.model.Employee;

public interface IEmployeeMgmtService 
{
	List<Employee> featchEmplyoeesByDesg(String desg1, String desg2, String desg3) throws Exception;
}
