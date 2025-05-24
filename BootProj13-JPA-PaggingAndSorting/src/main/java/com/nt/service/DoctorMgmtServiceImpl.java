package com.nt.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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
	public Iterable<Doctor> showDoctorBySorting(boolean ascOrder, String... props) 
	{
		// create sort object
		Sort 				sort 	=	Sort.by(ascOrder ? Direction.ASC : Direction.DESC, props);	
		
		// get all doctors
		Iterable<Doctor>	it		=	doctorRepo.findAll(sort);
		return it;
	}
	
	@Override
	public Page<Doctor> showDoctorInfoByPageNo(int pageNo, int pageSize, boolean ascOrder, String... props) {
		// create sort object
		Sort	sort	=	Sort.by(ascOrder ? Direction.ASC : Direction.DESC, props);	

		// create page request
		PageRequest pr= PageRequest.of(pageNo, pageSize, sort);
	    return doctorRepo.findAll(pr);
	}
	
	@Override
	public void showDataThroughtPagination(int pageSize) 
	{
		long count = doctorRepo.count();
		long pagesCount = count/pageSize;
		
		if (count%pageSize != 0)
		{
			pagesCount++;
		}
		
		for (int i=0; i<pagesCount; i++)
		{
			//create pageble object
			Pageable pagable = PageRequest.of(i, pageSize);
			
			//get page record
			Page<Doctor> page = doctorRepo.findAll(pagable);
			System.out.println("Page:: " + (page.getNumber() + 1) + "/" + page.getTotalPages());
			page.getContent().forEach(System.out::println);
			System.out.println("________________________________________________");
		}
				
	}
}
