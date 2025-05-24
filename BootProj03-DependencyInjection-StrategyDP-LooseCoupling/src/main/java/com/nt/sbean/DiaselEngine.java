package com.nt.sbean;

import org.springframework.stereotype.Component;

@Component("dislEng")
public class DiaselEngine implements IEngine
{
	public DiaselEngine()
	{
		System.out.println("DiaselEngine - 0 Param Constuctor");
	}
	
	@Override
	public void start() 
	{
		System.out.println("DiaselEngine.start()");
	}

	@Override
	public void stop() 
	{
		System.out.println("DiaselEngine.stop()");
	}

}
