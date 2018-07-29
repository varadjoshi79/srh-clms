package com.srh.clms.entities;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "WORK")
public class Work {
	
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "WORK_ID")		
	private int workId;
	@Column(name = "WORK_TYPE")
	private int workType;
	@Column(name = "WORK_DECSP")
	private String workDescp;
	@Column(name = "WORK_STATUS")
	private String workStatus;
	@Column(name = "START_DATE")
	private Date startDate;
	@Column(name = "END_DATE")
	private Date endDate;
	@Column(name = "REQ_PEOPLE")
	private int reqPeople;
	@Column(name = "NO_DAYS")
	private int noofdays;
	@Column(name="LABOUR_RATE")
	private float labourRate;

	public float getLabourRate() {
		return labourRate;
	}

	public void setLabourRate(float labourRate) {
		this.labourRate = labourRate;
	}

	@OneToOne
	@JoinColumn(name="CONTRACTOR_ID")
	private Contractor contractor;
	
	public Contractor getContractor() {
		return contractor;
	}

	public void setContractor(Contractor contractor) {
		this.contractor = contractor;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "PROJECT_PROJECT_ID")
	private Project project;
	
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	@OneToMany(mappedBy = "work", cascade = CascadeType.ALL)
	private Set<Labourer> labors = new HashSet<Labourer>(0);
	
	
	public Set<Labourer> getLabors() {
		return labors;
	}

	public void setLabors(Set<Labourer> labors) {
		this.labors = labors;
	}
	
	public Work() {

	}

	public int getWorkId() {
		return workId;
	}

	public void setWorkId(int workId) {
		this.workId = workId;
	}

	public int getWorkType() {
		return workType;
	}

	public void setWorkType(int workType) {
		this.workType = workType;
	}

	public String getWorkDescp() {
		return workDescp;
	}

	public void setWorkDescp(String workDescp) {
		this.workDescp = workDescp;
	}

	public String getWorkStatus() {
		return workStatus;
	}

	public void setWorkStatus(String workStatus) {
		this.workStatus = workStatus;
	}

	public Date getStartDate() {
		return startDate;
	}

	@Temporal(TemporalType.DATE)
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	@Temporal(TemporalType.DATE)
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getReqPeople() {
		return reqPeople;
	}

	public void setReqPeople(int reqPeople) {
		this.reqPeople = reqPeople;
	}

	public int getNoofdays() {
		return noofdays;
	}

	public void setNoofdays(int noofdays) {
		this.noofdays = noofdays;
	}

}
