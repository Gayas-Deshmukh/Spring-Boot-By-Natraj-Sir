package com.nt.service;

import java.util.List;
import com.nt.entity.Doctor;

public interface IDoctorService 
{
	String registerDoctor(Doctor doctor);
	boolean isDoctorExistsById(int id);
	long getDoctorsCount();
	Iterable<Doctor> getAllDoctord(List ids);
	Doctor getDoctorById(int id) throws Exception;
	String deleteDoctorById(int id);
}
