package com.nt.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.nt.model.Employee;

@Controller
public class DataRenderController
{
//	@GetMapping("/report")
//	public String sendData(Map<String, Object> map)
//	{
//		// put simple values to model attributes
//		
//		map.put("Name", "Gayas");
//		map.put("Age", 27);
//		
//		return "show_result";
//	}
	
//	@GetMapping("/report")
//	public String sendData(Map<String, Object> map)
//	{
//		// put array, collection to model attributes
//		
//		map.put("FavColor", new String [] {"Green", "Pink", "Yellow"});
//		map.put("NickNames", List.of("Ramesh", "Dipak", "Nitin"));
//		map.put("PhoneNum", Set.of(9855669, 5897899, 963258));
//		map.put("IdDetails", Map.of("Adhar", 74147852, "PAN", 852693));
//
//		return "show_result";
//	}
	
//	@GetMapping("/report")
//	public String sendData(Map<String, Object> map)
//	{
//		// put Model class obj to model attributes
//		
//		Employee emp = new Employee(123, "Rahul", 55000d, "Mumbai");
//		
//		map.put("Emp", emp);
//
//		return "show_result";
//	}
	
	@GetMapping("/report")
	public String sendData(Map<String, Object> map)
	{
		// Put collection Model class obj to model attributes
		Employee emp1 = new Employee(123, "Rahul", 55000d, "Mumbai");
		Employee emp2 = new Employee(456, "Ganesh", 68000d, "Hydrabad");
		Employee emp3 = new Employee(8987, "Nitin", 70000d, "Pune");

		map.put("Empls", List.of(emp1, emp2, emp3));

		return "show_result";
	}
	
}
