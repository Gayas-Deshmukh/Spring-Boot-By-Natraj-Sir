package com.nt.beans;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Setter;
import lombok.ToString;

@Component("emp")
@Setter
@ToString
@ConfigurationProperties(prefix = "org.nit")
public class Employee 
{
	private Integer eno;
	private String  ename;
	private String [] favColors;
	private List<String> nickNames;
	private Set<Long>	phoneNumbs;
	private Map<String, Object> idDetails;
	private Company company;
	
	// Read value from user defined properties/yml file
	private String empCity;
	private Double empSal;
}
