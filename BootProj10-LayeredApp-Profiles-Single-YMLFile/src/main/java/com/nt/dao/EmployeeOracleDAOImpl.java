package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import com.nt.model.Employee;


@Repository("empOracleDAO")
@Profile({"test", "uat"})
public class EmployeeOracleDAOImpl implements IEmployeeDAO 
{
	private static final String GET_EMPS_BY_DESG = "SELECT EMPNO, ENAME, JOB, SAL, DEPTNO FROM EMP WHERE JOB IN (?,?,?) ORDER BY JOB";
	
	@Autowired
	private DataSource ds;
	
	public EmployeeOracleDAOImpl()
	{
		System.out.println("EmployeeOracleDAOImpl - 0 param constructor");
	}
	
	@Override
	public List<Employee> getEmployeesByDesg(String desg1, String desg2, String desg3) throws Exception 
	{
		System.out.println("EmployeeDAOImpl.getEmployeesByDesg()- DataSource Class Name : " + ds.getClass());
		
		List<Employee> employees = null;
			
			// Get pooled jdbc con object
		try (Connection 		con	= ds.getConnection();
			 PreparedStatement 	ps 	= con.prepareStatement(GET_EMPS_BY_DESG))
		{
			ps.setString(1, desg1);
			ps.setString(2, desg2);
			ps.setString(3, desg3);
			
			try(ResultSet rs = ps.executeQuery()) 
			{
				employees	=	new ArrayList<>();
				
				while (rs.next()) 
				{
					Employee emp = new Employee();
					
					emp.setEno(rs.getInt(1));
					emp.setEname(rs.getString(2));
					emp.setDesg(rs.getString(3));
					emp.setSalary(rs.getDouble(4));
					emp.setDeptno(rs.getInt(5));
					
					employees.add(emp);
				}
			}			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			throw e;
		}
		
		return employees;
	}

}
