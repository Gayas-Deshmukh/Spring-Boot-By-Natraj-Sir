package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.nt.entity.Doctor;

// @Repository
// No need to add repository annotation here
// as the proxy implemetaion class of IDoctorRepo interface will automatically get marked as spring bean
public interface IDoctorRepo extends JpaRepository<Doctor, Integer>
{
	// select * from doctor where doc_name=name;
	public List<Doctor> findByDocNameEquals(String name);
	
	// select * from doctor where doc_name=name;
	public List<Doctor> findByDocNameIs(String name);
	
	// select * from doctor where doc_name=name;
	public List<Doctor> findByDocName(String name);
	
	// select * from doctor where specialization=initChars%;
	public List<Doctor> getBySpecializationStartingWith(String initChars);
	
	// select * from doctor where specialization7=%lastChars;
	public List<Doctor> getBySpecializationEndingWith(String lastChars);

	// select * from doctor where specialization7=%chars%;
	public List<Doctor> getBySpecializationContaining(String chars);
	
	// select * from doctor where income is null;
	public List<Doctor> getByIncomeIsNull();
	
	// select * from doctor where doc_name=name order by name desc;
	public List<Doctor> getByDocNameOrderByIncomeDesc(String name);
	
	// select * from doctor where doc_name like name;
	public List<Doctor> getByDocNameLike(String name);

}