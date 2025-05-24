package com.nt.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamResult 
{
	private Integer id;
	private Date dob;
	private Float percentage;	
	private Integer semister;
}
