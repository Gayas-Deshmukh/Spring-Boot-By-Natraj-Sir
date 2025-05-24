package com.nt.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer 
{
	private Integer cno;
	private String cname;
	private Double billamt;
	private String [] favColor;
	private List<String> studies;
	private Set<Long> phoneNums;
	private Map<String, Object> idDetails;
	private Company company;
}
