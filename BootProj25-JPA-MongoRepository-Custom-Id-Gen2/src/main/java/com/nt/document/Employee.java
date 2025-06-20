package com.nt.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "Employee")
@Data
public class Employee 
{
	@Id
	private Integer eno;
	private String ename;
	private String eadd;
	private Double salary;
	private boolean isVaccinated;
}
