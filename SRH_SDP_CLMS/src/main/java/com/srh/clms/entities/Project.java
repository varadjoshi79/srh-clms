package com.srh.clms.entities;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "PROJECT")
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PROJECT_ID")
	private int projectId;
	@Column(name = "PROJECT_NAME")
	private String projectName;
	@Column(name = "PROJECT_DESCP")
	private String projectdescription;
	@Column(name = "PROJECT_STATUS")
	private String status;
	@Column(name = "START_DATE")
	private Date projectStartDate;
	@Column(name = "END_DATE")
	private Date projectEndDate;
	@Column(name = "AMOUNT")
	private float amount;
	
	@Column(name = "CREATED_DATE")
	private Date projectCreationDate;
	@Column(name = "CREATED_BY")
	private String projectCreator;
	@Column(name = "LOCATION")
	private String location;

	@OneToOne(mappedBy = "project", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Builder builder;

	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
	private Set<Work> works = new HashSet<Work>(0);

	public Set<Work> getWork() {
		return works;
	}

	public void setWork(Set<Work> works) {
		this.works = works;
	}

	public Builder getBuilder() {
		return builder;
	}

	public void setBuilder(Builder builder) {
		this.builder = builder;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectdescription() {
		return projectdescription;
	}

	public void setProjectdescription(String projectdescription) {
		this.projectdescription = projectdescription;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getProjectStartDate() {
		return projectStartDate;
	}

	@Temporal(TemporalType.DATE)
	public void setProjectStartDate(Date startDate) {
		this.projectStartDate = startDate;
	}

	public Date getProjectEndDate() {
		return projectEndDate;
	}

	@Temporal(TemporalType.DATE)
	public void setProjectEndDate(Date projectEndDate) {
		this.projectEndDate = projectEndDate;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Date getProjectCreationDate() {
		return projectCreationDate;
	}

	@Temporal(TemporalType.DATE)
	public void setProjectCreationDate(Date projectCreationDate) {
		this.projectCreationDate = projectCreationDate;
	}

	public String getProjectCreator() {
		return projectCreator;
	}

	public void setProjectCreator(String projectCreator) {
		this.projectCreator = projectCreator;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
