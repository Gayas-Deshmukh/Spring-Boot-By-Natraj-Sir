package com.nt.service;

import java.util.List;

import com.nt.entity.Tourist;

public interface ITouristMgmtService 
{
	String registerTourist(Tourist tourist);
	List<Tourist> fetchAllTourist();
	Tourist fetchTouristById(Integer id) throws Exception;
	List<Tourist> fetchAllTouristByCities(String city1, String city2, String city3);
	String updateTouristDetails(Tourist tourist)  throws Exception;
	String updateTouristBudgetById(Integer id, double perHike)  throws Exception;
	String removeTouristById(Integer id) throws Exception;

}
