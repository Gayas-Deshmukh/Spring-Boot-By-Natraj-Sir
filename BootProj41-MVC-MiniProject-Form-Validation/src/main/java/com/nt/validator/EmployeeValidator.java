package com.nt.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.nt.model.Employee;

@Component
public class EmployeeValidator implements Validator
{
	@Override
	public boolean supports(Class<?> clazz) 
	{
		if (clazz.isAssignableFrom(Employee.class))
		{
			return true;
		}
		
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) 
	{
		Employee employee = (Employee)target;
		
		if (employee.getEname() == null || employee.getEname().isBlank())
		{
			errors.rejectValue("ename", "emp.name.required");
		}
		else if (!(employee.getEname().length() >=5 && employee.getEname().length() <=15))
		{
			errors.rejectValue("ename", "emp.name.length");
		}
		
		if (employee.getDeg() == null || employee.getDeg().isBlank())
		{
			errors.rejectValue("deg", "emp.deg.required");
		}
		else if (!(employee.getDeg().length() >=2 && employee.getDeg().length() <=15))
		{
			errors.rejectValue("deg", "emp.deg.length");
		}
		
		if (employee.getSal() == null)
		{
			errors.rejectValue("sal", "emp.sal.required");
		}
		else if (!(employee.getSal() >=10000 && employee.getSal() <=90000))
		{
			errors.rejectValue("sal", "emp.sal.range");
		}
	}
}
