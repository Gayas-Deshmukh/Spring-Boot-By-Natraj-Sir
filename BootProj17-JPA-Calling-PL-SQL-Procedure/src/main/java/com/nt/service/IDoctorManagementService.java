package com.nt.service;

import java.util.List;

import com.nt.entity.Doctor;

public interface IDoctorManagementService 
{
	public List<Doctor> getDoctorsByIncome(Double start, Double end);
}
