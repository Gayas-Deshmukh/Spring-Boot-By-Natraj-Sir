package com.nt.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;

@Controller
public class EmployeeOperationController
{
	@Autowired
	private IEmployeeMgmtService emplService;
	
	@GetMapping("/")
	public String showHome()
	{
		return "home";
	}
	
	@GetMapping("/emp-report")
	public String showEmployeeReport(Map<String, Object> model)
	{
		Iterable<Employee> employees = emplService.getEmployee();
		
		model.put("emplList", employees);
		
		return "show_emp_report";
	}
	
	@GetMapping("/add-emp")
	public String showAddEmployeeForm(@ModelAttribute("emp") Employee emp)
	{
		return "register_employee";
	}
	
	@PostMapping("/add-emp")
	public String saveEmployee(@ModelAttribute("emp") Employee emp, RedirectAttributes attribs)
	{
		String msg = emplService.registerEmployee(emp);
		
		attribs.addFlashAttribute("resultMsg", msg);
		
		return "redirect:/emp-report";
	}
	
	@GetMapping("/edit")
	public String showEditEmployeeFormPage(@RequestParam("eno") int no, @ModelAttribute("emp") Employee emp)
	{
		Employee dbEmpl = emplService.getEmployeeByNo(no);
		
		BeanUtils.copyProperties(dbEmpl, emp);
		
		return "edit_employee";
	}
	
	@PostMapping("/edit")
	public String editEmployeeFormPage(@ModelAttribute("emp") Employee emp, RedirectAttributes attribs)
	{
		String updatedEmpMsg = emplService.updateEmployee(emp);
		
		attribs.addFlashAttribute("resultMsg", updatedEmpMsg);

		return "redirect:/emp-report";
	}
	
	@GetMapping("/delete")
	public String deleteEmplyee(@RequestParam("eno") int no, RedirectAttributes attribs)
	{
		String deletemsg = emplService.deleteEmployeeById(no);
		
		attribs.addFlashAttribute("resultMsg", deletemsg);

		return "redirect:/emp-report";
	}
}
