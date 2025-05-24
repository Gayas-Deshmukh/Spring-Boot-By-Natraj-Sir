package com.nt.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.nt.entity.Doctor;

public interface IDoctorService 
{
	public String deleteDoctorsByIdsInBatch(List<Integer> ids);
	public List<Doctor> showDoctorsByExampleData(Doctor doctor, boolean ascOrder, String ... props);
	public Doctor findDoctorById(int id);
}
