package com.nt.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.nt.entity.Doctor;

public interface IDoctorService 
{
	Iterable<Doctor> showDoctorBySorting(boolean ascOrder, String ... props);
	Page<Doctor> showDoctorInfoByPageNo(int pageNo, int pageSize, boolean ascOrder, String ... props);
	void showDataThroughtPagination(int pageSize);
}
