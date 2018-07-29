package com.srh.clms.entities;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "SALARY")
public class Salary {

	@Id
	@Column(name = "SALARY_ID")
	private int salary_id;
	@Column(name = "SALARY_MODE")
	private int salaryMode;
	@Column(name = "STATUS")
	private String status;
	@Column(name = "AMOUNT")
	private double amount;
	@Column(name = "RECIEVED_DATE")
	private Date recieveDate;
	
	@ManyToOne
	@JoinColumn(name="LABOURER_ID_INFO")
	private Labourer labour;
	
	@ManyToOne
	@JoinColumn(name="CONTRACTOR_ID_INFO")
	private Contractor contractor;
	
	
	public Salary() 
	{

	}

	public int getSalaryMode() {
		return salaryMode;
	}

	public int getSalary_id() {
		return salary_id;
	}

	public void setSalary_id(int salary_id) {
		this.salary_id = salary_id;
	}

	public Labourer getLabor() {
		return labour;
	}

	public void setLabor(Labourer labor) {
		this.labour = labor;
	}


	public Contractor getContractor() {
		return contractor;
	}

	public void setContractor(Contractor contractor) {
		this.contractor = contractor;
	}

	public void setSalaryMode(int salaryMode) {
		this.salaryMode = salaryMode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getRecieveDate() {
		return recieveDate;
	}

	public void setRecieveDate(Date recieveDate) {
		this.recieveDate = recieveDate;
	}

	
}