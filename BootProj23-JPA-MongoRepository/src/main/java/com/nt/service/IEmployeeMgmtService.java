package com.nt.service;

import java.util.List;
import com.nt.document.Employee;

public interface IEmployeeMgmtService 
{
	public String saveEmployee(Employee e);
	public List<Employee> getAllEmployees();
	public String searchEmployeeById(String id);
	public String modifyEmployeeById(String id, Double salary);
	public String deleteEmployeeById(String id);
    public List<Employee> getAllEmployees(boolean order, String ...properties);

}
