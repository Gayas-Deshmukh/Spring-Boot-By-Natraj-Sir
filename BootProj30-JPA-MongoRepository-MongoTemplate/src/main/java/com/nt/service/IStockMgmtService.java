package com.nt.service;

import java.util.List;

import com.nt.document.StockDetails;

public interface IStockMgmtService 
{
	public String registorStockDetails(StockDetails details);
	public String registorStockDetailsBatch(List<StockDetails> list);
	public List<StockDetails> fetchStockDetailsByExchange(String exchangeName);
	public List<StockDetails> fetchStockDetailsByPriceRange(Double start, Double end);
	public StockDetails findStockDetailsById(int id);
	public String fetchAndUpdateStockDetailsById(int id);
	public String modifyExchangeByStockPriceRange(Double start, Double end,String exchangeName);
	public String findAndRemovedByStockName(String stockName);
}
