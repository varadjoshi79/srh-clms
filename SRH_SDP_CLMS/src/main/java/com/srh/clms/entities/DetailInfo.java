package com.srh.clms.entities;


import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "DETAIL_INFO")
@Inheritance(strategy = InheritanceType.JOINED)
public class DetailInfo 
{
	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_INFO",updatable = false)
	private int infoId;	
	@Column(name="FIRST_NAME",updatable = false)
	private String firstName;
	@Column(name="LAST_NAME",updatable = false)
	private String lastName;
	@Column(name="ADDRESS",updatable = false)
	private String address;
	@Column(name="CONTACT",updatable = false)
	private String contact;
	@Column(name="EMAIL",updatable = false)
	private String email;
	@Column(name="USERNAME",updatable = false)
	private String username;
	@Column(name="PASSWORD",updatable = false)
	private String password;
	@Column(name="DATE_OF_BIRTH",updatable = false)
	private Date birthDate;
	@Column(name="GENDER",updatable = false)
	private char gender;
	@Column(name="USER_TYPE",updatable = false)	
	private String userType;
	@Column(name="WORK_PERMIT_NO",updatable = false)
	private String workPermitNo;
	@Column (name="CREATION_DATE",updatable = false)
	private Date creationDate;
	
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public String getWorkPermitNo() {
		return workPermitNo;
	}
	public void setWorkPermitNo(String workPermitNo) {
		this.workPermitNo = workPermitNo;
	}	
	public DetailInfo()
	{		
	}
	public int getInfoId() {
		return infoId;
	}
	public void setInfoId(int infoId) {
		this.infoId = infoId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Date getBirthDate() {
		return birthDate;
	}
	@Temporal(TemporalType.DATE)
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	
}
