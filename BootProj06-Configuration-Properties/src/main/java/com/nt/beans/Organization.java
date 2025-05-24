package com.nt.beans;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Setter;
import lombok.ToString;

@Component("organization")
@Setter
@ToString
@ConfigurationProperties("org.nt")
public class Organization 
{
	private String [] 			branches;
	private List<String>		owners;
	private Set<Long> 			phones;
	private	Map<String, Object>	idDetails;
	private License         	licenseDetails;
}
