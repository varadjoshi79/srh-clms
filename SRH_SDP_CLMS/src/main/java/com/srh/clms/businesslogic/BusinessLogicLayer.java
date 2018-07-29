package com.srh.clms.businesslogic;
import com.srh.clms.dataaccess.*;
import com.srh.clms.entities.*;

import com.srh.clms.exception.*;

public class BusinessLogicLayer 
{
	boolean flag =true;
	DataAccessLayer dal = new DataAccessLayer();
	public boolean addAccount(Account account)
	{
		flag= dal.addAccountDLL(account);
		return flag;
	}
	
	public boolean addBuilder(Builder builder)
	{
		System.out.print("Add Builder in bll");
		flag=dal.addBuilder(builder);
		
		return flag;
	}
	
	public boolean addProject(Project project,Builder builder) throws InterruptedException
	{
		
		flag=dal.addProjectDAL(project,builder);
		return flag;
	}
	
	public DetailInfo userLogin(String username,String password)
	{
		DetailInfo info=null;
		
		info = dal.userLoginDAL(username, password);
		
		return info;
	}
	
	public Builder getBuilderDetailsBLL(int infoId)
	{
		Builder builder = null;
		builder = dal.getBuilderDetailsDAL(infoId);
		return builder;
		
	}
	
	public boolean addLabour(Labourer labor)//
	{
		flag= dal.addLabourDLL(labor);//
		return flag;
	}
	
	public boolean addContractor(Contractor contractor)//
	{
		flag= dal.addContractorDLL(contractor);//
		return flag;
	}
	
	public boolean addWork(Work work, Project project) {		
		flag = dal.AddWorkDLL(work, project);
		return flag;
	}
	
	public void displayAllWorkBLL()
	{
		dal.displayAllWorkDLL();
	}
	
	public void displayAllProjectsBLL()
	{
		dal.displayAllProjectsDLL();
	}
	
	public void displayWorkContractorBLL(int workType)
	{
		
		dal.displayWorkContractorDLL(workType);
		
	}
	
	public boolean applyWorkContractorBLL(Work work,Contractor contractor) throws SecurityException, InterruptedException
	{
		flag= dal.applyWorkContractorDLL(work,contractor);
		return flag;
	}
	
	public void displayWorkLaborBLL(int type) {
		
		dal.displayWorkLaborDLL(type);
		
	}
	
	public Work getWorkByIdBLL(int id)
	{
		Work work=null;
		work =dal.getWorkByIdDLL(id);
		return work;
	}
	
	public boolean assignWorkLabourBLL(Labourer labor, Work work) {
		boolean assign = dal.assignWorkLabourDLL(labor, work);
		return assign;
	}
	
	public Labourer getLabourDetailsBLL(int infoId) {
		Labourer labor = null;
		labor = dal.getLabourDetailsDAL(infoId);
		return labor;
	}
	public Contractor getContractorByWork(int idWork) {
		Contractor contractor = dal.getContractorByWork(idWork);
		return contractor;
	}
	public boolean saveAttendance(Labourer labor, Attendance attend,Salary sal,Contractor contractor,Account acct) {
		boolean save = dal.saveAttendance(labor,attend,sal,contractor,acct);
		return false;
	}
	public Account getAccountDetail(int infoId) {
		Account acct = dal.getAccountDetail(infoId);
		return acct;
	}
	public void displaySalaryBLL(int cId,Salary sal)
	{
		dal.displaySalaryDLL(cId,sal);
	}
	
	public Contractor getContractorDetailsBLL(int infoId) {
		Contractor contractor = null;
		contractor = dal.getContractorDetailsDAL(infoId);
		return contractor;
	}
	
}
