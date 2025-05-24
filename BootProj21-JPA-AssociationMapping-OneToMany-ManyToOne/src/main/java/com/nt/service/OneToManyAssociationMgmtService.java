package com.nt.service;

public interface OneToManyAssociationMgmtService 
{
	public void saveDataUsingParent();
	public void saveDataUsingChild();
	public void loadDataUsingParent();
	public void loadDataUsingChild();
	public void deleteDataUsingParent(int id);
	public void deleteDataUsingChild(int id);
	public void deleteAllPhoneNumbersOfPerson(int pid);
	public void addNewChildToExistingParent(int pid);
}
