package com.nt.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReportController 
{
	/*
	@GetMapping("/data")
	public String process(@RequestParam("sno") int sno, @RequestParam("sname") String sname)
	{
		System.out.println("sno=" + sno + "..........." + "sname="+ sname);
		return "show_result";
	}
	*/
	
	/*
	@GetMapping("/data")
	public String process(@RequestParam int sno, @RequestParam(required = false) String sname)
	{
		System.out.println("sno=" + sno + "..........." + "sname="+ sname);
		return "show_result";
	}
	*/
	
	/*
	@GetMapping("/data")
	public String process(@RequestParam int sno, @RequestParam(required = false, defaultValue = "KK") String sname)
	{
		System.out.println("sno=" + sno + "..........." + "sname="+ sname);
		return "show_result";
	}
	*/
	
	/*
	@GetMapping("/data")
	public String process(@RequestParam int sno, 
						  @RequestParam(required = false, defaultValue = "KK") String sname,
						  @RequestParam("sadd") String [] adds,
						  @RequestParam("sadd") List<String> addList,
						  @RequestParam("sadd") Set<String> addSet)
	{
		// http://localhost:8480/data?sno=101&sname=JJ&sadd=HDY&sadd=Pune&sadd=mumbai
		
		System.out.println("sno=" + sno + "..........." + "sname="+ sname);
		System.out.println("Array=" + Arrays.toString(adds) + "....List=" + addList + "...Set="+addSet);

		return "show_result";
	}
	*/
	
	@GetMapping("/data")
	public String process(@RequestParam int sno, 
						  @RequestParam(required = false, defaultValue = "KK") String sname,
						  @RequestParam("sadd") String adds)
	{
		// http://localhost:8480/data?sno=101&sname=JJ&sadd=HDY&sadd=Pune&sadd=mumbai
		
		System.out.println("sno=" + sno + "..........." + "sname="+ sname + "..........." + "sadds="+ adds);

		// Output - sno=101...........sname=JJ...........sadds=HDY,Pune,mumbai
		return "show_result";
	}
}
