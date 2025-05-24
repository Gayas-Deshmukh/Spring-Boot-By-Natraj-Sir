package com.nt.sbean;

import org.springframework.stereotype.Component;

@Component("cngEng")
public class CNGEngine implements IEngine
{
	public CNGEngine()
	{
		System.out.println("CNGEngine - 0 Param Constuctor");
	}
	
	@Override
	public void start() 
	{
		System.out.println("CNGEngine.start()");
	}

	@Override
	public void stop() 
	{
		System.out.println("CNGEngine.stop()");
	}

}
