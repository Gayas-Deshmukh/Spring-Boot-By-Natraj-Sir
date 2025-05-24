package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.Person;

public interface IPersonRepository extends JpaRepository<Person, Integer> 
{
//	@Query("select pr.pid, pr.pname, pr.paddrs, num.number, num.provider from Person pr inner join pr.numbers num")
//	@Query("select pr.pid, pr.pname, pr.paddrs, num.number, num.provider from Person pr left join pr.numbers num")
//	@Query("select pr.pid, pr.pname, pr.paddrs, num.number, num.provider from Person pr right join pr.numbers num")
	public List<Object[]> fetchDataUsingJoinsByParent();
	
// full join - check IPhoneNuberRepositoy for ref
	
	/** Notes **/
	/*
	 * MySQL does not support a direct FULL OUTER JOIN syntax, 
	 * but you can achieve similar results by combining LEFT JOIN and RIGHT JOIN with a UNION.
	 * HQL does not support the UNION keyword directly within the @Query annotation.
	 */
}
