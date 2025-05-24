package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.service.ISeasonFinderService;

@Controller
public class SeasonFinderController
{
	@Autowired
	ISeasonFinderService seasonSeasonFinderService;
	
	@RequestMapping("/")
	public String showHome()
	{
		System.out.println("SeasonFinderController.showHome()");
		
		return "welcome";
	}
	
	@RequestMapping("/getSeason")
	public String getSeason(Map<String, Object> map)
	{
		System.out.println("SeasonFinderController.getSeason()");
		
		map.put("season", seasonSeasonFinderService.findSeason());
		
		return "season";
	}
}
