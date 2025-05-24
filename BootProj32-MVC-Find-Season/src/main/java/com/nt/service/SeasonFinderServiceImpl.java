package com.nt.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

@Service
public class SeasonFinderServiceImpl implements ISeasonFinderService
{
	@Override
	public String findSeason()
	{
		int monthValue = LocalDate.now().getMonthValue();
		
		if (monthValue >= 2 && monthValue <=5)
		{
			return "Summer";
		}
		else if (monthValue >= 6 && monthValue <= 9)
		{
			return "Rainy";
		}
		if (monthValue >= 10 || monthValue <=1)
		{
			return "Winter";
		}
		
		return null;
	}

}
