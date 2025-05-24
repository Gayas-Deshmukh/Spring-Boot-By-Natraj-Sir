package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController 
{
	@GetMapping(path = {"", "/"})
	public String showHome()
	{
		return "redirect:/employee/";
	}
}
