package com.nt.sbean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("vehical")
public class Vehical 
{
	@Autowired
	@Qualifier("cngEng")
	private IEngine engine;
	
	public void Journey(String startPlace, String stopPlace)
	{
		engine.start();
		
		System.out.println("Journey started at - " + startPlace);
		System.out.println("Journey is going on...");
		
		engine.stop();
		
		System.out.println("Journey stopped at - " + stopPlace);		
	}
}
