package com.nt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee 
{
	private Integer empNo;
	private String empName;
	private Double empSalary;
	private String empAdd;
}
