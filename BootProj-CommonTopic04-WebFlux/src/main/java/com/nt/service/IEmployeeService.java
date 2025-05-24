package com.nt.service;

import com.nt.model.Employee;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IEmployeeService 
{
	public Mono<Employee> saveEmployee(Employee emp);
	public Flux<Employee> findAllEmployees();
	public Mono<Employee> getEmployeeById(String empId);
	public Mono<Void> deleteEmployee(String empId);
}
