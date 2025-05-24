package com.nt.sbeans;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("sf")
public class SeasonFinder 
{
	@Autowired
	private LocalDate ldt;
	
	
	public String findSession()
	{
		int monthValue = ldt.getMonthValue();
		
		if (monthValue >= 3 && monthValue <= 6)
		{
			return "Summer Season";
		}
		else if (monthValue >= 7 && monthValue <=10)
		{
			return "Rainy Season";
		}
		else 
		{
			return "Winter Season";
		}
	}
}
