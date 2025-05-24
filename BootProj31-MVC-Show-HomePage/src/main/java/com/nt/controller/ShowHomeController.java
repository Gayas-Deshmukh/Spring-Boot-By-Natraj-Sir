package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ShowHomeController
{
	/*
	@RequestMapping("/home")
	public String showHome()
	{
		return "welcome";
	}
	*/
	
	/*
	@RequestMapping("/home")
	public String showHome(Map<String, Object> map)
	{
		System.out.println("Shared Memory Class Object :" + map.getClass());
		
		map.put("attr1", "val");
		map.put("sysDt", LocalDateTime.now());
		
		return "welcome";
	}
	*/
	
	/*
	@RequestMapping("/home")
	public String showHome(Model model)
	{
		System.out.println("Shared Memory Class Object :" + model.getClass());
		
		model.addAttribute("attr1", "val");
		model.addAttribute("sysDt", LocalDateTime.now());
		
		return "welcome";
	}
	*/
	
	/*
	@RequestMapping("/home")
	public String showHome(ModelMap model)
	{
		System.out.println("Shared Memory Class Object :" + model.getClass());
		
		model.addAttribute("attr1", "val");
		model.addAttribute("sysDt", LocalDateTime.now());
		
		return "welcome";
	}
	*/
	
	/*
	@RequestMapping("/home")
	public Model showHome()
	{

		Model model = new BindingAwareModelMap();
		
		model.addAttribute("attr1", "val");
		model.addAttribute("sysDt", LocalDateTime.now());
		
		return model;
	}
	*/
	
	/*
	@RequestMapping("/home")
	public Map<String, Object> showHome()
	{
		Map<String, Object> map = new HashMap<>();
		
		map.put("attr1", "val");
		map.put("sysDt", LocalDateTime.now());
		
		return map;
	}
	*/
	
	/*
	@RequestMapping("/home")
	public ModelAndView showHome()
	{
		ModelAndView modelView = new ModelAndView();
		
		modelView.addObject("attr1", "val");
		modelView.addObject("sysDt", LocalDateTime.now());
		modelView.setViewName("welcome");
		
		return modelView;
	}
	*/
	
	/*
	@RequestMapping("/welcome")
	public void showHome(Map<String, Object> map)
	{
		System.out.println("Shared Memory Class Object :" + map.getClass());
		
		map.put("attr1", "val");
		map.put("sysDt", LocalDateTime.now());		
	}
	*/
	
	@RequestMapping("/welcome")
	public String showHome(Map<String, Object> map)
	{
		System.out.println("Shared Memory Class Object :" + map.getClass());
		
		map.put("attr1", "val");
		map.put("sysDt", LocalDateTime.now());	
		
		return null;
	}
	
	/*
	// forward request
	@RequestMapping("/process")
	public String process()
	{
		System.out.println("ShowHomeController.process()");
		
		return "forward:report";
	}
	
	@RequestMapping("/report")
	public String showReport()
	{
		System.out.println("ShowHomeController.showReport()");	
		
		return "show_data";
	}
	*/
	
	/*
	// redirect request
	@RequestMapping("/process")
	public String process(HttpServletRequest req)
	{
		System.out.println("ShowHomeController.process() :: " + req.hashCode());
		
		req.setAttribute("att1", "Hi");
		
		return "redirect:report";
	}
	
	@RequestMapping("/report")
	public String showReport(HttpServletRequest req)
	{
		System.out.println("req attribute :: " + req.getAttribute("attr1"));
		System.out.println("ShowHomeController.showReport()");	
		
		return "show_data";
	}
	*/
	
	@RequestMapping("/process")
	public void process(HttpServletResponse resp) throws IOException
	{
		PrintWriter pw = resp.getWriter();
		
		resp.setContentType("text/html");
		
		pw.println("<b> Direct from Handler method</b>");
	}
}
