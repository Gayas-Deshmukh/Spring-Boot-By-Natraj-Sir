package com.nt.sbean;

import org.springframework.stereotype.Component;

@Component("petrolEng")
public class PetrolEngine implements IEngine
{
	public PetrolEngine()
	{
		System.out.println("PetrolEngine - 0 Param Constuctor");
	}
	
	@Override
	public void start() 
	{
		System.out.println("PetrolEngine.start()");
	}

	@Override
	public void stop() 
	{
		System.out.println("PetrolEngine.stop()");
	}

}
