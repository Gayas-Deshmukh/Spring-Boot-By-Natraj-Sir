package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.nt.document.Employee;
import com.nt.repository.IEmployeeRepo;


@Component
public class EmployeeTestRunner implements CommandLineRunner 
{
	@Autowired
	private IEmployeeRepo emplRepo;
	
	@Override
	public void run(String... args) throws Exception 
	{
		/*
		List<Object[]> empDataByAdds = emplRepo.getEmpDataByAdds("Akola");
		
		empDataByAdds.forEach(row -> {
			for (Object data : row)
			{
				System.out.print(data + " ");
			}
			
			System.out.println();
		});
		*/
		
		/*******************************/
		
		//emplRepo.getEmpAllDataByAdds("Nashik").forEach(System.out :: println);
		
		/*******************************/

		//emplRepo.getEmpAllDataByAddsAndName("Nashik", "Rahul").forEach(System.out :: println);
		
		/*******************************/
		
		//emplRepo.getEmpAllDataBySalaryRange(50000, 70000).forEach(System.out :: println);

		/*******************************/

		//emplRepo.getEmpAllDataByAddresses("Pune", "Nashik").forEach(System.out :: println);

		/*******************************/

		emplRepo.getEmpAllDataByEnameInitialChars("SHI").forEach(System.out :: println);

	}
}
