package com.nt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nt.entity.Tourist;

public interface ITouristRepo extends JpaRepository<Tourist, Integer>
{
	@Query("from Tourist where city in (:city1, :city2, :city3) order by name asc")
	List<Tourist> findTouristByCities(@Param("city1") String city1, @Param("city2") String city2, @Param("city3") String city3);
}
