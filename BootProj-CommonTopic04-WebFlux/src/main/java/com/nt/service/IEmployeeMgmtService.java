package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.Employee;
import com.nt.repo.EmployeeRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class IEmployeeMgmtService implements IEmployeeService
{
	@Autowired
	private EmployeeRepository repo;

	@Override
	public Mono<Employee> saveEmployee(Employee emp)
	{
		return repo.save(emp);
	}

	@Override
	public Flux<Employee> findAllEmployees()
	{
		return repo.findAll().switchIfEmpty(Flux.empty());
	}

	@Override
	public Mono<Employee> getEmployeeById(String empId)
	{
		return repo.findById(empId).switchIfEmpty(Mono.empty());
	}

	@Override
	public Mono<Void> deleteEmployee(String empId)
	{
		return repo.deleteById(empId);
	}
}
