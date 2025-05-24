package com.nt.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime purchaseDate;
	
	private String [] favColor;
	private List<String> studies;
	private Set<Long> phoneNums;
	private Map<String, Object> idDetails;
	
	private Company company;
}
