package com.nt.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Setter;
import lombok.ToString;

@Component("company")
@Setter
@ToString
@ConfigurationProperties(prefix = "org.nit")
@PropertySource("App.properties")
public class Company 
{
	/*
	private String name;
	private String addrs;
	private String pincode;
	private String contact;
	*/
	// Output - Company(name=NareshIT, addrs=Hdy, pincode=25896, contact=98777)
	
	private String name;
	private String addrs;
	private String pincode;
	
	@Value("${nit.phone}") // Field Injection - this will be override by setter injection done by @ConfigurationProperties 
	private String contact;
	
	@Value("${nit.size}")
	private Integer size;
}
