package com.nt.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.nt.model.Employee;

public interface EmployeeRepository extends ReactiveMongoRepository<Employee, String>
{

}
