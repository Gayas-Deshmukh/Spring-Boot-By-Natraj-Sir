package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.nt.entity.CallerTuneInfo;
import com.nt.service.ICallerTuneMgmtService;

@Component
public class CallerTuneTestRunner implements CommandLineRunner 
{
	@Autowired
	private ICallerTuneMgmtService callerTuneMgmtService;
	
	@Override
	public void run(String... args) throws Exception 
	{
		/*
		CallerTuneInfo cInfo = new CallerTuneInfo();
		
		cInfo.setTuneName("Luttu Muttya");
		
		System.out.println(callerTuneMgmtService.saveCallerTuneInfor(cInfo));
		*/
		
		System.out.println(callerTuneMgmtService.updateTuneInfoById(1, "Main "));
		
		//System.out.println(callerTuneMgmtService.getCallerTuneInfoById(1));
	}
}
