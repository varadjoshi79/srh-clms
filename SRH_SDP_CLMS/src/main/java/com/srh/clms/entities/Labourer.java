package com.srh.clms.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "LABOURER")
public class Labourer extends Account 
{
	@Column(name = "LABOURER_TYPE")
	private int labourType;
	@Column(name = "WORK_DESCP")
	private String workDescp;
	@Column(name = "SKILL")
	private String skill;
	@Column(name = "EXPERIENCE")
	private float experience;
	@Column(name = "AVAILABLE")
	private char available;
	@Column(name = "CARD_ID")
	private Long cardId;

	public Labourer() {
		
	}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "WORK_WORK_ID")
	private Work work;
	
	public Work getWork() {
		return work;
	}
	@OneToMany(mappedBy="labour",cascade = CascadeType.ALL)
	private Set<Attendance> attendences = new HashSet<Attendance>(0);

	
	public Set<Attendance> getAttendences() {
		return attendences;
	}

	public void setAttendences(Set<Attendance> attendences) {
		this.attendences = attendences;
	}
	@OneToMany(mappedBy="labour",cascade = CascadeType.ALL)
	private Set<Salary> salaries = new HashSet<Salary>(0);
	

	public Set<Salary> getSalaries() {
		return salaries;
	}

	public void setSalaries(Set<Salary> salaries) {
		this.salaries = salaries;
	}
	
	

	public void setWork(Work work) {
		this.work = work;
	}

	public int getLabourType() {
		return labourType;
	}

	public void setLabourType(int labourType) {
		this.labourType = labourType;
	}

	public String getWorkDescp() {
		return workDescp;
	}

	public void setWorkDescp(String workDescp) {
		this.workDescp = workDescp;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}


	public float getExperience() {
		return experience;
	}

	public void setExperience(float experience) {
		this.experience = experience;
	}

	public char getAvailable() {
		return available;
	}

	public void setAvailable(char available) {
		this.available = available;
	}
	public Long getCardId() {
		return cardId;
	}

	public void setCardId(Long cardId) {
		this.cardId = cardId;
	}
}