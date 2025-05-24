package com.nt.service;

import java.util.List;

import com.nt.entity.Tourist;
import com.nt.exception.TouristNotFoundExeption;

public interface ITouristMgmtService 
{
	String registerTourist(Tourist tourist) throws Exception;;
	List<Tourist> fetchAllTourist() throws Exception;;
	Tourist fetchTouristById(Integer id) throws TouristNotFoundExeption;
	List<Tourist> fetchAllTouristByCities(String city1, String city2, String city3) throws Exception;;
	String updateTouristDetails(Tourist tourist)  throws TouristNotFoundExeption;
	String updateTouristBudgetById(Integer id, double perHike)  throws TouristNotFoundExeption;
	String removeTouristById(Integer id) throws Exception;

}
