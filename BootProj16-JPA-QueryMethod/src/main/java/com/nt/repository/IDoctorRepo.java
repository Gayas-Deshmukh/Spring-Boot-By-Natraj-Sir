package com.nt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nt.entity.Doctor;

// @Repository
// No need to add repository annotation here
// as the proxy implemetaion class of IDoctorRepo interface will automatically get marked as spring bean
public interface IDoctorRepo extends JpaRepository<Doctor, Integer>
{
	//@Query("from Doctor where income>=?1 and income <=?2")  // Ordinal Positional params
	//@Query("from com.nt.entity.Doctor where income>=?1 and income <=?2")  // Ordinal Positional params
	//@Query("from Doctor doc where doc.income>=?1 and doc.income <=?2")  // Ordinal Positional params	
	//@Query("from Doctor doc where doc.income>=? and doc.income <=?")  // java.lang.IllegalArgumentException: JDBC style parameters (?) are not supported for JPA queries
	//@Query("select doc from Doctor doc where doc.income>=?1 and doc.income <=?2")  // Ordinal Positional params	
/*	public List<Doctor> searchDoctorByIncomeRange(double startRange, double endRange);*/
	
	//@Query("from Doctor where income>=:start and income <=:end")  // named params
/*	public List<Doctor> searchDoctorByIncomeRange(@Param("start") double startRange, @Param("end") double endRange); */

	@Query("from Doctor where income>=:start and income <=:end")  // named params
	public List<Doctor> searchDoctorByIncomeRange(double start, double end);
	
	/* Select -Entity Query */
	@Query("from Doctor where specialization in (:sp1,:sp2) order by specialization")
	public List<Doctor> searchDoctorsBySpecialization(String sp1, String sp2);
	
	/* select -Projection Query with specific multiple cols values */
	@Query("select docId, docName, income from Doctor where income between :start and :end")
	public List<Object[]> searchDoctorsByIncome(double start, double end);

	/* select -Projection Query with specific single col values */
	@Query("select docName from Doctor where income between :start and :end")
	public List<String> searchAllDoctorsNamesByIncome(double start, double end);

	/* Entity Query giving single record */
	@Query("from Doctor where docName =:name")
	public Optional<Doctor> showDoctorInfoByName(String name);
	
	/* Scalar Query giving single record multiple col values */
	@Query("select docId, docName from Doctor where docName =:name")
	public Object showDoctorSomeDataByName(String name);
	
	/* Scalar Query giving single record single col value */
	@Query("select specialization from Doctor where docName =:name")
	public String showDoctorSpecialization(String name);
	
	/** Aggregate Function **/
	
	@Query("select count(*), max(income), min(income), sum(income), avg(income) from Doctor")
	public Object fetchAggregateData();
	
	/**  Non select operation **/
	
	@Query("UPDATE Doctor SET income=income+(income*:per/100) where specialization=:sp")
	@Modifying
	@Transactional
	public int hikeDoctorIncomeBySpecialization(String sp, double per);
	
	@Query("DELETE from Doctor where docName=:name")
	@Modifying
	@Transactional
	public int removeDoctorByName(String name);
	
	/** Native SQL Queries**/
	
	/* INSERT Native Query */
	@Query(value = "insert into doctor (doc_id, doc_name, income, specialization) values (:id, :docname, :incm, :sp)", nativeQuery = true)
	@Modifying
	@Transactional
	public int registorDoctor(int id, String docname, Double incm, String sp);
	
	/* SELECT Native Query */
	@Query(value = "select now() from dual", nativeQuery = true)
	public String showSystemDate();

	/* DDL Native Query */
	@Query(value = "create table temp(col1 integer, col2 varchar(20))", nativeQuery = true)
	@Modifying
	@Transactional
	public int TempTable();

}