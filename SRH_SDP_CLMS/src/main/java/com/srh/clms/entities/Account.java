package com.srh.clms.entities;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "ACCOUNT")
public class Account extends DetailInfo
{
@Column(name="BALANCE",updatable = false)
	private double Balance;
@Column(name="MODE",updatable = false)
	private String  mode;
@Column(name="ACCOUNT_NUMBER",updatable = false)
	private String AccountNumber;
@Column(name="DATE_OF_UPDATION",updatable = false)
	private Date DateOfUpdation;

	public Account()
	{
	}
	
	public double getBalance() {
		return Balance;
	}
	public void setBalance(double balance) {
		this.Balance = balance;
	}
	public String getMode() {
		return mode;
	}
	
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.AccountNumber = accountNumber;
	}
	public Date getDateOfUpdation() {
		return DateOfUpdation;
	}
	@Temporal(TemporalType.DATE)
	public void setDateOfUpdation(Date dateOfUpdation) {
		this.DateOfUpdation = dateOfUpdation;
	}

}
