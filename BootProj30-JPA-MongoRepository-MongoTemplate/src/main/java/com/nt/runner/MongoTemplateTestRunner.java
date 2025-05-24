package com.nt.runner;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.document.StockDetails;
import com.nt.service.IStockMgmtService;

@Component
public class MongoTemplateTestRunner implements CommandLineRunner 
{
	@Autowired
	private IStockMgmtService service;
	
	@Override
	public void run(String... args) throws Exception 
	{
		StockDetails stockDetails = new StockDetails(new Random().nextInt(), "ICICI", 5899d, "BSE");
		
		//System.out.println(service.registorStockDetails(stockDetails));
		
		/************************************************************/
		
		StockDetails stockDetails1 = new StockDetails(new Random().nextInt(), "TATA", 8745d, "BSE");
		StockDetails stockDetails2 = new StockDetails(new Random().nextInt(), "JIO", 87456d, "BSE");
		
		//System.out.println(service.registorStockDetailsBatch(List.of(stockDetails1, stockDetails2)));	
	
		/************************************************************/

		//service.fetchStockDetailsByExchange("BSE").forEach(System.out::println);
		
		System.out.println("-------------------------------------------------");
		
		//service.fetchStockDetailsByPriceRange(4000d, 9000d).forEach(System.out::println);
		
		/************************************************************/
		
		//System.out.println(service.findStockDetailsById(972627492));
		
		/************************************************************/
		
		//System.out.println(service.fetchAndUpdateStockDetailsById(972627492));
		
		/************************************************************/

		//System.out.println(service.modifyExchangeByStockPriceRange(4000d, 9000d, "Nifty"));
	
		/************************************************************/

		System.out.println(service.findAndRemovedByStockName("JIO"));
	
	}

}
