package com.nt.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nt.entity.Doctor;
import com.nt.repository.IDoctorRepo;


@Service("docMgntSer")
public class DoctorMgmtServiceImpl implements IDoctorService
{
	@Autowired
	private IDoctorRepo doctorRepo;
	
	@Override
	public String registerDoctor(Doctor doctor) 
	{				
		Doctor savedDoctor = doctorRepo.save(doctor);
		
		return "Doctor " + savedDoctor.getDocId() + " inserted successfully.";
	}

	@Override
	public Doctor getDoctorById(int id) throws Exception 
	{
		Optional<Doctor> doctor	= doctorRepo.findById(id);
		
		/*
		if (doctor.isPresent())
		{
			return doctor.get();
		}
		else 
		{
			throw new Exception("Doctor not found with given id " + id);
		}
		*/
		
		return doctor.orElse(new Doctor());

		//return doctor.orElseThrow(() -> new Exception("Doctor not found with given id " + id));
	}

	@Override
	public boolean isDoctorExistsById(int id)
	{
		return doctorRepo.existsById(id);
	}

	@Override
	public long getDoctorsCount()
	{
		return doctorRepo.count();
	}
	
	@Override
	public Iterable<Doctor> getAllDoctord(List ids) 
	{
		return doctorRepo.findAllById(ids);
	}
	
	@Override
	public String deleteDoctorById(int id) 
	{
		Optional<Doctor> doctor = doctorRepo.findById(id);
		
		if (doctor.isPresent())
		{
			doctorRepo.deleteById(id);
			
			return "Doctor with id " + id + " has been deleted";
		}
		else
		{
			return "Doctor with id " + id + " not found";
		}
	}
}
