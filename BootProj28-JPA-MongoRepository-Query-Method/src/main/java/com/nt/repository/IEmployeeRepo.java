package com.nt.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.nt.document.Employee;

public interface IEmployeeRepo extends MongoRepository<Employee, String> 
{
	/** Projection Query **/
	//@Query(fields = "{eno:1, ename:1, salary:1}", value = "{eadd:?0}")
	@Query(fields = "{id:0, eno:1, ename:1, salary:1}", value = "{eadd:?0}")
	public List<Object[]> getEmpDataByAdds(String adds);
	
	
	/** Entity Query **/
	//@Query(fields = "{}", value = "{eadd:?0}")
	@Query(value = "{eadd:?0}")
	public List<Employee> getEmpAllDataByAdds(String adds);
	
	@Query(value = "{eadd:?0, ename:?1}")
	public List<Employee> getEmpAllDataByAddsAndName(String adds, String name);
	
	//@Query(value = "{salary:{$gte:?0, $lte:?1}}")
	@Query(value = "{salary:{$gte:?0}, salary:{$lte:?1}}")
	public List<Employee> getEmpAllDataBySalaryRange(double start, double end);
	
	@Query(value = "{$or:[{eadd:?0},{eadd:?1}]}")
	public List<Employee> getEmpAllDataByAddresses(String add1, String add2);
	
	//@Query(value = "{ename:{'$regex':?0}}") // where ename like %_%
	@Query(value = "{ename:{'$regex':?0,'$options':'i'}}") // where ename like %_%, i- for case insensivity	
	public List<Employee> getEmpAllDataByEnameInitialChars(String initialchars);

}
	