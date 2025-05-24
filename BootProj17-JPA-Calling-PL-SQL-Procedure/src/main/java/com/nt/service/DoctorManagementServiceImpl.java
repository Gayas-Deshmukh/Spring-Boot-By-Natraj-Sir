package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.nt.entity.Doctor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

@Service
public class DoctorManagementServiceImpl implements IDoctorManagementService 
{

	@Autowired
	private EntityManager entityMgr;
	
	/* Stored Procedure
	 
	 	USE `spring-boot(natraj)`;
		DROP procedure IF EXISTS `ps_get_doctor_by_income`;
		
		DELIMITER $$
		USE `spring-boot(natraj)`$$
		CREATE PROCEDURE `ps_get_doctor_by_income` (in start float, in end float)
		BEGIN
		 select * from doctor where income>=start and income<=end;
		END$$
		
		DELIMITER ;
	 */
	@Override
	public List<Doctor> getDoctorsByIncome(Double start, Double end) 
	{
		// Create Stored Procedure
		StoredProcedureQuery	query	=	entityMgr.createStoredProcedureQuery("ps_get_doctor_by_income", Doctor.class);
		
		//Register the parameter of Stored Procedure		
		query.registerStoredProcedureParameter(1, Double.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, Double.class, ParameterMode.IN);

		//Set Parameter Value
		query.setParameter(1, start);
		query.setParameter(2, end);
		
		// Call PL/SQL Procedure
		List<Doctor> list= query.getResultList();
		return list;
	}

}
