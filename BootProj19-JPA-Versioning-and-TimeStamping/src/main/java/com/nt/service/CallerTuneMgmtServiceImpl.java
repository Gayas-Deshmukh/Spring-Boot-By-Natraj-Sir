package com.nt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.CallerTuneInfo;
import com.nt.repository.ICallerTuneInfoRepository;

@Service
public class CallerTuneMgmtServiceImpl implements ICallerTuneMgmtService 
{
	@Autowired
	private ICallerTuneInfoRepository callerTuneInfoRepo;
	
	@Override
	public String saveCallerTuneInfor(CallerTuneInfo callerTuneInfo) 
	{
		Integer id = callerTuneInfoRepo.save(callerTuneInfo).getTuneId();
		
		return "Caller Tune is saved with Id value : " + id;
	}

	@Override
	public String updateTuneInfoById(int id, String tuneName) 
	{
		Optional<CallerTuneInfo> optional = callerTuneInfoRepo.findById(id);
		
		if (optional.isPresent())
		{
			CallerTuneInfo callerTuneInfo = optional.get();
			
			callerTuneInfo.setTuneName(tuneName);
			
			CallerTuneInfo savedCalledTune = callerTuneInfoRepo.save(callerTuneInfo);
			
			return "Object is updated for " + savedCalledTune.getUpdatedCount() +
					" times... lastly modified on :" + savedCalledTune.getLastlyUpdatedOn() +
					" ... created on :" + savedCalledTune.getOptedOn();
		}
		else
		{
			return "CallerTuneInfo not found for id :" + id;
		}
	}

	@Override
	public CallerTuneInfo getCallerTuneInfoById(int id) 
	{
		return callerTuneInfoRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("CallerTuneInfo not found with given id "+ id));
	}
}
