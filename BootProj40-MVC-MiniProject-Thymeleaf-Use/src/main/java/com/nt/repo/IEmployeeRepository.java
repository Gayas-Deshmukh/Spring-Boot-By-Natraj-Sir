package com.nt.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.nt.model.Employee;

public interface IEmployeeRepository extends CrudRepository<Employee, Integer>
{

}
