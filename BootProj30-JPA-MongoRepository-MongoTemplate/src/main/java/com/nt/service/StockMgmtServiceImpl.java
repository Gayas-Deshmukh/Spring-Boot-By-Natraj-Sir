package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.mongodb.client.result.UpdateResult;
import com.nt.document.StockDetails;

@Service
public class StockMgmtServiceImpl implements IStockMgmtService
{
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public String registorStockDetails(StockDetails details) 
	{
		int id = mongoTemplate.insert(details, "Stock").getStockId(); // save with custom collection name
		//int id = mongoTemplate.insert(details).getStockId();
		
		return "Stock details has been saved with id value : " + id;
	}

	@Override
	public String registorStockDetailsBatch(List<StockDetails> list) 
	{
		mongoTemplate.insertAll(list);
		
		return list.size() + " StockDetails has been saved";
	}

	@Override
	public List<StockDetails> fetchStockDetailsByExchange(String exchangeName) 
	{
		Query query = new Query();
		
		query.addCriteria(Criteria.where("exchangeName").is(exchangeName));
		
		return mongoTemplate.find(query, StockDetails.class);
	}

	@Override
	public List<StockDetails> fetchStockDetailsByPriceRange(Double start, Double end) 
	{
		Query query = new Query();
		
		query.addCriteria(Criteria.where("price").gte(start).andOperator(Criteria.where("price").lte(end)));
		
		return mongoTemplate.find(query, StockDetails.class);
	}

	@Override
	public StockDetails findStockDetailsById(int id) 
	{
	    return mongoTemplate.findById(id, StockDetails.class);
	}

	@Override
	public String fetchAndUpdateStockDetailsById(int id) 
	{
		Query query = new Query();	
		query.addCriteria(Criteria.where("stockId").is(id));
		
		Update update = new Update();
		
		update.set("price", 15200);
		update.set("exchangeName", "NSE");

		StockDetails details = mongoTemplate.findAndModify(query, update, StockDetails.class);
		
		return details == null ? "Details are not found" : "Stock details are found & updated";
	}

	@Override
	public String modifyExchangeByStockPriceRange(Double start, Double end, String exchangeName)
	{
		Query query = new Query();
		query.addCriteria(Criteria.where("price").gte(start).andOperator(Criteria.where("price").lte(end)));
		
		Update update = new Update();
		update.set("exchangeName", exchangeName);	
		
		UpdateResult updateResult = mongoTemplate.updateMulti(query, update, StockDetails.class);
		
		return updateResult.getModifiedCount() + " no. of record are affected";
	}

	@Override
	public String findAndRemovedByStockName(String stockName) 
	{
		Query query = new Query();	
		query.addCriteria(Criteria.where("stockName").is(stockName));
		
		StockDetails stockDetails = mongoTemplate.findAndRemove(query, StockDetails.class);
		
		return stockDetails == null ? "Details are not found" : "Stock details are found & deleted";
	}
	
	
	
}
