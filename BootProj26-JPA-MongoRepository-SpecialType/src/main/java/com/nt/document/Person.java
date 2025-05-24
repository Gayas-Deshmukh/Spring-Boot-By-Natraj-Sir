package com.nt.document;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Document
@Data
public class Person 
{
	@Id
	private Integer pId;
	private String pname;
	private String [] simcards;
	private List<String> nickNames;
	private Set<Long> contactNos;
	private Map<String, String> bikeswithPrice;
	private Properties idDetails;
}
