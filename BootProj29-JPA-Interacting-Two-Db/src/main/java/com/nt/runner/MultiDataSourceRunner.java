package com.nt.runner;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.model.prod.Product;
import com.nt.model.promotions.Offers;
import com.nt.repo.prod.IProductRepo;
import com.nt.repo.promotion.IOffersRepo;

@Component
public class MultiDataSourceRunner implements CommandLineRunner 
{
	@Autowired
	private IProductRepo productRepo;
	
	@Autowired
	private IOffersRepo offerRepo;
	
	@Override
	public void run(String... args) throws Exception 
	{
		Product prod = new Product();
		prod.setPname("Mobile");
		prod.setPrice(25000d);
		prod.setQty(1);
		
		//productRepo.save(prod);
		
		System.out.println("Product is saved");
			
		productRepo.findAll().forEach(System.out::println);
		
		/*********************************************/
		
		System.out.println("=====================================");
		
		Offers offers = new Offers();
		
		offers.setOfferName("Buy 1- Get 1 Free");
		offers.setOfferCode("WESD");
		offers.setDiscountPer(30d);
		offers.setExpDate(LocalDateTime.now());
		
		offerRepo.save(offers);
		
		System.out.println("Offer is saved");
		
		offerRepo.findAll().forEach(System.out::println);

	}

}
