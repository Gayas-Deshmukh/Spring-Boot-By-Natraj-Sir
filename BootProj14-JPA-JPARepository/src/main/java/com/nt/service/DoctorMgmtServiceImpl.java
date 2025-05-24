package com.nt.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import com.nt.entity.Doctor;
import com.nt.repository.IDoctorRepo;


@Service("docMgntSer")
public class DoctorMgmtServiceImpl implements IDoctorService
{
	@Autowired
	private IDoctorRepo doctorRepo;

	@Override
	public String deleteDoctorsByIdsInBatch(List<Integer> ids) 
	{
		// load the entities
		List<Doctor> doctorList = doctorRepo.findAllById(ids);
		
		// delete the entities with given ids
		doctorRepo.deleteAllByIdInBatch(ids);
		
		return doctorList.size() + " records are deleted";
	}
	
	@Override
	public List<Doctor> showDoctorsByExampleData(Doctor doctor, boolean ascOrder, String... props) 
	{
		// create sort object
		Sort sort = Sort.by(ascOrder ? Direction.ASC : Direction.DESC, props);
		
		// create Example obj
		Example<Doctor> example = Example.of(doctor);
		
		return doctorRepo.findAll(example, sort);
	}

	@Override
	public Doctor findDoctorById(int id) 
	{
		return doctorRepo.getReferenceById(id);
	}
	
	
}
