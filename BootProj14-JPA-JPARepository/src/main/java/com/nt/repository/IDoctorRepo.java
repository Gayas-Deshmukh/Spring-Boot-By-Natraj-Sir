package com.nt.repository;

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
	
}