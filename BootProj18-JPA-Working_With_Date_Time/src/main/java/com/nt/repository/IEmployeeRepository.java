package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer>
{
	@Query(nativeQuery=true, value="select YEAR(CURRENT_TIMESTAMP)-YEAR(dob) from employee where ename=:name")
	public Double getEmplyeeAgeByName(String name);
}
