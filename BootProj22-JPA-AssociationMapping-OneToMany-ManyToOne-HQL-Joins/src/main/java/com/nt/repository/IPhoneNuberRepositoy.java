package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.PhoneNumber;

public interface IPhoneNuberRepositoy extends JpaRepository<PhoneNumber, Integer> 
{
//	@Query("select ph.id, ph.number, ph.provider, pr.pname, pr.paddrs from PhoneNumber ph inner join ph.personInfo pr")
//	@Query("select ph.id, ph.number, ph.provider, pr.pname, pr.paddrs from PhoneNumber ph left join ph.personInfo pr")
//	@Query("select ph.id, ph.number, ph.provider, pr.pname, pr.paddrs from PhoneNumber ph right join ph.personInfo pr")
//	public List<Object[]> fetchDataUsingJoinsByChild();
	
// full join with native sql query
	@Query(value = "SELECT ph.id, ph.number, ph.provider, pr.pname, pr.paddrs " +
            "FROM phone_number ph LEFT JOIN person pr ON ph.person_id = pr.pid " +
            "UNION " +
            "SELECT ph.id, ph.number, ph.provider, pr.pname, pr.paddrs " +
            "FROM phone_number ph RIGHT JOIN person pr ON ph.person_id = pr.pid",
            nativeQuery = true)
	List<Object[]> fetchDataUsingJoinsByChild();
	
	/** Notes **/
	/*
	 * MySQL does not support a direct FULL OUTER JOIN syntax, 
	 * but you can achieve similar results by combining LEFT JOIN and RIGHT JOIN with a UNION.
	 * HQL does not support the UNION keyword directly within the @Query annotation.
	 */
	
}
