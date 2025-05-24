package com.nt.service;

import com.nt.entity.CallerTuneInfo;

public interface ICallerTuneMgmtService 
{
	public String saveCallerTuneInfor(CallerTuneInfo callerTuneInfo);
	public String updateTuneInfoById(int id, String tuneName);
	public CallerTuneInfo getCallerTuneInfoById(int id);
}
