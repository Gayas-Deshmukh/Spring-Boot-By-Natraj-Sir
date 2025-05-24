package com.nt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "BATCH_EMPLOYEE")
public class Employee 
{
	@Id
	private Integer empno;
	
	private String empname;
	
	private String empaddrs;
	
	private Double salary;
	
	private Double grossSalary;
	
	private Double netSalary;
}
