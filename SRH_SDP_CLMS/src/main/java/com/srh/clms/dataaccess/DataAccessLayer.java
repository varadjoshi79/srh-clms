package com.srh.clms.dataaccess;

import com.srh.clms.businesslogic.*;
import com.srh.clms.exception.*;
import com.srh.clms.entities.*;

import java.util.List;
import java.util.logging.Level;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

public class DataAccessLayer {

	boolean flag = true;
	int workId=0;
	int contractorId=0;
	protected static SessionFactory sessionfactory;

	protected void setup() {
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
		// A SessionFactory is set up once for an application!
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build(); 
		try {
			sessionfactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception e) {
			StandardServiceRegistryBuilder.destroy(registry);
			throw new RuntimeException(e);
		}
	}

	protected void exit() {
		sessionfactory.close();
	}

	public boolean addAccountDLL(Account account) {
		try {
			DataAccessLayer dataAccess = new DataAccessLayer();
			flag = true;
			dataAccess.setup();
			Session session = sessionfactory.openSession();
			session.beginTransaction();
			session.save(account);
			session.getTransaction().commit();
			session.close();
			dataAccess.exit();

		} catch (Exception e) {
			System.out.println(e.getMessage() + e.getLocalizedMessage() + e.getStackTrace());
		}

		return flag;
	}

	public boolean addBuilder(Builder builder) {
		try {
			DataAccessLayer dataAccess = new DataAccessLayer();
			flag = true;
			dataAccess.setup();
			System.out.println("setup done");
			Session session = sessionfactory.openSession();
			session.beginTransaction();
			session.save(builder);
			session.getTransaction().commit();
			session.close();
			dataAccess.exit();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return flag;
	}

	public boolean addLabourDLL(Labourer labor) {
		try {
			flag = true;
			DataAccessLayer dataAccess = new DataAccessLayer();
			dataAccess.setup();
			Session session = dataAccess.sessionfactory.openSession();
			session.beginTransaction();
			session.save(labor);

			session.getTransaction().commit();
			session.close();
			dataAccess.exit();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean addContractorDLL(Contractor contractor) {
		try {
			flag = true;
			DataAccessLayer dataAccess = new DataAccessLayer();
			dataAccess.setup();
			Session session = dataAccess.sessionfactory.openSession();
			session.beginTransaction();
			session.save(contractor);
			session.getTransaction().commit();
			session.close();
			dataAccess.exit();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean addProjectDAL(Project project, Builder builder) throws InterruptedException {

		try {
			System.out.print("in add project DAL");
			DataAccessLayer dataAccess = new DataAccessLayer();
			dataAccess.setup();
			org.hibernate.Session session = sessionfactory.openSession();
			session.beginTransaction();			
			session.save(project);			
			builder.setProject(project);
			System.out.println("updating builder");
			session.saveOrUpdate(builder);

			session.getTransaction().commit();

			session.close();
			dataAccess.exit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}

		return flag;
	}

	public DetailInfo userLoginDAL(String username, String password) {
		{
			DetailInfo info = null;
			try {
				DataAccessLayer dataAccess = new DataAccessLayer();
				dataAccess.setup();
				Session session = sessionfactory.openSession();
				session.beginTransaction();
				Query query = session
						.createQuery("from DetailInfo where username = :username and password = :password");
				query.setParameter("username", username);
				query.setParameter("password", password);

				info = (DetailInfo) query.list().get(0);
				session.getTransaction().commit();

				session.close();
				dataAccess.exit();

			} catch (Exception e) {
				e.printStackTrace();
			}
			return info;
		}
	}

	public Builder getBuilderDetailsDAL(int infoId) {
		Builder builder = null;
		try {

			DataAccessLayer dataAccess = new DataAccessLayer();
			dataAccess.setup();
			Session session = sessionfactory.openSession();
			session.beginTransaction();
			Query query = session.createQuery("from Builder where builder.ID_INFO =1");
			// query.setParameter("detailInfoId", infoId);
			builder = (Builder) query.list().get(0);
			if (builder != null) {
				session.close();

				dataAccess.exit();
				return builder;
			}
			session.getTransaction().commit();
			session.close();

		}

		catch (Exception e) {
			throw new RuntimeException(e);
		}
		return builder;
	}

	public boolean AddWorkDLL(Work work, Project project) {
		try {

		flag = true;
		DataAccessLayer dataAccess = new DataAccessLayer();
		dataAccess.setup();
		org.hibernate.Session session = sessionfactory.openSession();
		session.beginTransaction();

		work.setProject(project);
		// session.saveOrUpdate(project);
		session.save(work);
		session.getTransaction().commit();
		session.close();
		dataAccess.exit();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
			
		}
		return flag;
	}

	public void displayAllWorkDLL() {
		int id = 0;
		try {
			DataAccessLayer dataAccess = new DataAccessLayer();
			dataAccess.setup();
			Session session = sessionfactory.openSession();
			Query q = session.createQuery("from Work");
			java.util.Iterator itr = q.iterate();
			System.out.println(
					"|Work Id " + "||" + " Work Type " + "||" + " Work Description " + "||" + " Work Status |");
			while (itr.hasNext()) 
			{

				Work w = (Work) itr.next();
				System.out.println();
				System.out.println(w.getWorkId() +"||" + w.getWorkType() + "||" + w.getWorkDescp() + "||"+ w.getWorkStatus() + "|");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void displayAllProjectsDLL() {
		int id = 0;
		try {
			DataAccessLayer dataAccess = new DataAccessLayer();
			dataAccess.setup();
			Session session = sessionfactory.openSession();
			Query q = session.createQuery("from Project");
			java.util.Iterator itr = q.iterate();
			System.out.println("|Project Id " + "||" + " Project Name " + "||" + " Project Description " + "||"+ " Project Status |");
			while (itr.hasNext()) {
				Project proj = (Project) itr.next();
				System.out.println();
				System.out.println("|" + proj.getProjectId() + "||" + proj.getProjectName() + "||"+ proj.getProjectdescription() + "||" + proj.getStatus() + "|");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public  void displayWorkContractorDLL(int workType) 
	{
		{ 
			Contractor contractor = null;
			Work work=null;
			
			try {
				
			DataAccessLayer dataAccess= new DataAccessLayer();
			dataAccess.setup();
			Session session =  dataAccess.sessionfactory.openSession();
			session.beginTransaction();
		
	           Criteria c = session.createCriteria(Work.class);
	           c.add(Restrictions.eq("workType", workType ));
	           c.add(contractor == null ? Restrictions.isNull("contractor") : Restrictions.eq("contractor", contractor));
	           
	   	    	List<Work> results= c.list();
	   	    	
	   	    	for(int i=0;i<results.size();i++)
	   	    	{
	   	    		work=(Work) c.list().get(i);
	   	    		
	   	    		System.out.println("\n Work ID: "+work.getWorkId()+"\n Work Type: "+work.getWorkType()+"\n Work Description: "+work.getWorkDescp()+"\n Status: "+work.getWorkStatus()+"\n startdate:"+work.getStartDate()+"\n end date"+work.getEndDate()+"\n people:"+work.getReqPeople()+"\n days:"+work.getNoofdays());
	   	    	}
	   	    	workId=work.getWorkId();
		    }
		  
		
		catch(Exception e) 
			{
		e.printStackTrace();
		
		}
		}
	}
	public boolean applyWorkContractorDLL(Work work,Contractor contractor) throws InterruptedException, SecurityException
	{
		try {
			
			
			DataAccessLayer dataAccess = new DataAccessLayer();
			dataAccess.setup();
			Session session = sessionfactory.openSession();		
			
			session.beginTransaction();			
			work=(Work)session.load( Work.class, workId);
			
			contractor.setInfoId(contractor.getInfoId());
			work.setContractor(contractor);			
			System.out.println("updating Work");
		    session.saveOrUpdate(work);
            
		    session.getTransaction().commit();
			sessionfactory.close();
			dataAccess.exit();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	        return flag;
	        
	}
	
	public void displayWorkLaborDLL(int type) {

			int id = 0;
			boolean contractor = false;
			try {
				DataAccessLayer dataAccess = new DataAccessLayer();
				dataAccess.setup();
				Session session = sessionfactory.openSession();
				System.out.println(type);
				session.beginTransaction();
				Criteria c = session.createCriteria(Work.class);
				c.add(Restrictions.eq("workType", type));
				c.add(Restrictions.isNotNull("contractor")); 
				List<Work> results =  c.list();
				System.out.println(
						"|Work Id " + "||" + " Work Type " + "||" + " Work Description " + "||" +
						" Work Status || ");
					for(int i=0;i< results.size();i++)
		   	    	{
		   	    		Work w=(Work) c.list().get(i);
					System.out.println();
					System.out.println(w.getWorkId() + "     " + "||" + w.getWorkType() + "||" + w.getWorkDescp() + "||"
							+ w.getWorkStatus() + "|");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	
	public Work getWorkByIdDLL(int id) {
		Work work = null;
		try {

			DataAccessLayer dataAccess = new DataAccessLayer();
			dataAccess.setup();
			Session session = sessionfactory.openSession();
			session.beginTransaction();
			
			Query query = session.createQuery("from Work where work_id = :workid");
			query.setParameter("workid", id);
			work = (Work) query.list().get(0);
			if (work != null) {
				session.close();

				dataAccess.exit();
				return work;
			}
			session.getTransaction().commit();
			session.close();

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return work;
	}
	
	public boolean assignWorkLabourDLL(Labourer labor, Work work) {
		boolean assign = false;
		
		flag = true;
		try {
			DataAccessLayer dataAccess = new DataAccessLayer();
			dataAccess.setup();
			org.hibernate.Session session = sessionfactory.openSession();
			session.beginTransaction();
			
			labor.setAvailable('N');
			labor.setWork(work);
			session.saveOrUpdate(labor);
			// session.save(labor);
			session.getTransaction().commit();
			session.close();
			dataAccess.exit();
		} catch (Exception e) {

			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return assign;
	}
	
	public Labourer getLabourDetailsDAL(int infoId) {
		Labourer labor = null;
		try {

			DataAccessLayer dataAccess = new DataAccessLayer();
			dataAccess.setup();
			Session session = sessionfactory.openSession();
			session.beginTransaction();
						
			Query q = session.createQuery("from Labourer where infoId = :detailInfoId");
			q.setInteger("detailInfoId", infoId);
			labor = (Labourer) q.list().get(0);
			if (labor != null) {
				session.close();

				dataAccess.exit();
				return labor;
			}
			session.getTransaction().commit();
			session.close();

		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return labor;

	}
	
	public Contractor getContractorDetailsDAL(int infoId) {
		Contractor contractor = null;
		try {

			DataAccessLayer dataAccess = new DataAccessLayer();
			dataAccess.setup();
			Session session = sessionfactory.openSession();
			session.beginTransaction();
						
			Query q = session.createQuery("from Contractor where infoId = :detailInfoId");
			q.setInteger("detailInfoId", infoId);
			contractor = (Contractor) q.list().get(0);
			if (contractor != null) {
				session.close();

				dataAccess.exit();
				return contractor;
			}
			session.getTransaction().commit();
			session.close();

		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return contractor;

	}
	
	public Contractor getContractorByWork(int idWork) {
		Contractor contractor = null;
		try
		{
			DataAccessLayer dataAccess = new DataAccessLayer();
			dataAccess.setup();
			Session session = sessionfactory.openSession();
			session.beginTransaction();
			System.out.println(idWork);
			Query query = session.createQuery("from Contractor where infoId = :workid");
			query.setParameter("workid", idWork);
			contractor = (Contractor) query.list().get(0);
			if (contractor != null) {
				session.close();

				dataAccess.exit();
				return contractor;
			}
			session.getTransaction().commit();
			session.close();

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return contractor;
	}
	
	public boolean saveAttendance(Labourer labor, Attendance attend,Salary sal,Contractor contractor,Account acct) {
		boolean save = false;
		try {

			DataAccessLayer dataAccess = new DataAccessLayer();
			dataAccess.setup();
			Session session = sessionfactory.openSession();
			session.beginTransaction();
			attend.setLabour(labor);			
			 sal.setLabor(labor);
			 sal.setContractor(contractor);
			session.save(sal);
			session.save(attend);
			save = true;
			session.getTransaction().commit();
			session.close();

		}catch (Exception e) {
			e.printStackTrace();
		}
		return save;
	}
	
	public Account getAccountDetail(int infoId) {
		Account acct = null;
		try
		{
			DataAccessLayer dataAccess = new DataAccessLayer();
			dataAccess.setup();
			Session session = sessionfactory.openSession();
			session.beginTransaction();
			System.out.println(infoId);
			Query query = session.createQuery("from Account where infoId = :infoId");
			query.setParameter("infoId", infoId);
			acct = (Account) query.list().get(0);
			if (acct != null) {
				session.close();

				dataAccess.exit();
				return acct;
			}
			session.getTransaction().commit();
			session.close();

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return acct;
	}
	
	public  void   displaySalaryDLL(int cId,Salary sal) 
	{ 
		//System.out.println(cId);
		Salary salary = null;
		try {
		DataAccessLayer dataAccess= new DataAccessLayer();
		dataAccess.setup();
		Session session =  dataAccess.sessionfactory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from Salary where CONTRACTOR_ID_INFO= :contractor and status= :status");
		
		query.setParameter("contractor", cId);
		query.setParameter("status", "Pending");
	    java.util.Iterator itr = query.iterate();
	    while (itr.hasNext()) 
	    {
	         salary = (Salary) itr.next();
	         System.out.println("\n Salary ID: "+salary.getSalary_id()+"\n Salary Mode: "+salary.getSalaryMode()+"\n Salary Status: "+salary.getStatus()+"\n Amount to be paid "+salary.getAmount()+"\n Received Dtae: "+salary.getRecieveDate());
	         salary.setStatus("PAID");
	 	     salary.setRecieveDate(sal.getRecieveDate());
	 	     session.saveOrUpdate(salary);
	 	    System.out.println(" SALARY PENDING ");
	    } 
	    System.out.println("-------");	    
	    System.out.println(" SALARY PAID ");
	  
	    session.getTransaction().commit();
		sessionfactory.close();
	    }
	  
	
	catch(Exception e) 
		{
	e.printStackTrace();
	}
	
	
	}
}
