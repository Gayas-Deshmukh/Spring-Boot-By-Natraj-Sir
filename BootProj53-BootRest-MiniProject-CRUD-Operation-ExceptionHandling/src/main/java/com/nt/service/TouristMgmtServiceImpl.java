package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Tourist;
import com.nt.exception.TouristNotFoundExeption;
import com.nt.repo.ITouristRepo;

@Service
public class TouristMgmtServiceImpl implements ITouristMgmtService
{
	@Autowired
	private ITouristRepo touristRepo;
	
	@Override
	public String registerTourist(Tourist tourist) throws Exception
	{
		Integer tid = touristRepo.save(tourist).getTid();
		return "Tourist saved with id :" + tid;
	}

	@Override
	public List<Tourist> fetchAllTourist() throws Exception
	{
		List<Tourist> allTourist = touristRepo.findAll();
		
		allTourist.sort((t1, t2) -> t1.getTid().compareTo(t2.getTid()));
		return allTourist;
	}

	@Override
	public Tourist fetchTouristById(Integer id) throws TouristNotFoundExeption 
	{
		return touristRepo.findById(id).orElseThrow(() -> new TouristNotFoundExeption("Tourist not found with given id :" + id));
	}

	@Override
	public List<Tourist> fetchAllTouristByCities(String city1, String city2, String city3) throws Exception
	{
		return touristRepo.findTouristByCities(city1, city2, city3);
	}

	@Override
	public String updateTouristDetails(Tourist tourist) throws TouristNotFoundExeption
	{
		Optional<Tourist> optional = touristRepo.findById(tourist.getTid());
		
		if (optional.isPresent())
		{
			touristRepo.save(tourist);
			
			return "Updated Tourist with id : " + tourist.getTid();
		}
		else
		{
			throw new TouristNotFoundExeption("Tourist not found with given id :" + tourist.getTid());
		}		
	}

	@Override
	public String updateTouristBudgetById(Integer id, double perHike) throws TouristNotFoundExeption 
	{
		Optional<Tourist> optional = touristRepo.findById(id);
		
		if (optional.isPresent())
		{
			Tourist tourist 	= 	optional.get();
			Double  budget		=	tourist.getBudget();
			Double  budgetHike	= 	budget + (budget * (perHike/100));
			
			tourist.setBudget(budgetHike);
			
			touristRepo.save(tourist);
			
			return "Tourist budget is hiked with amt " + budgetHike;
		}
		else
		{
			throw new TouristNotFoundExeption("Tourist not found with given id :" + id);
		}
	}

	@Override
	public String removeTouristById(Integer id) throws Exception 
	{
		Optional<Tourist> optional = touristRepo.findById(id);
		
		if (optional.isPresent())
		{
			touristRepo.deleteById(id);
			
			return "Deleted Tourist with id : " + id;
		}
		else
		{
			throw new Exception("Tourist not found with given id :" + id);
		}
	}
}
