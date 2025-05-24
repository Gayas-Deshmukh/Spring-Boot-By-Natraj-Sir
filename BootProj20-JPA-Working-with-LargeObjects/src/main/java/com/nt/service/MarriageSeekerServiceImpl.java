package com.nt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.MarriageSeeker;
import com.nt.repository.IMarriageSeekerRepo;

@Service
public class MarriageSeekerServiceImpl implements IMarrigeSeekerService
{
	@Autowired
	private IMarriageSeekerRepo marrigeSeekerRepo;

	@Override
	public String registerMarriageSeeker(MarriageSeeker seeker) 
	{
		return "Marrige seeker info saved with id value : " + marrigeSeekerRepo.save(seeker);
	}

	@Override
	public Optional<MarriageSeeker> searchSeekerById(int id) 
	{
		return marrigeSeekerRepo.findById(id);
	}

}
