package com.nt.service;

import java.util.List;

public interface OneToManyAssociationMgmtService 
{
	public List<Object []> fetchDataUsingJoinsByParent();
	public List<Object []> fetchDataUsingJoinsByChild();
}
