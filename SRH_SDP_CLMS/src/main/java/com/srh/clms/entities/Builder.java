package com.srh.clms.entities;

import javax.persistence.*;

@Entity
@Table(name = "BUILDER")
public class Builder extends Account {

	@Column(name="BUILDER_TYPE",updatable = false)
	private int buildType;
	public int getBuildType() {
		return buildType;
	}

	public void setBuildType(int buildType) {
		this.buildType = buildType;
	}


	@Column(name = "TYPE_DESCP",updatable = false)
	private String typeDescription;
	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}


	public Builder() 
	{

	}


	@Column(name = "EXPERIENCE",updatable = false)
	private int experience;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROJECT_PROJECT_ID")
	private Project project;

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getTypeDescription() {
		return typeDescription;
	}

	public void setTypeDescription(String typeDescription) {
		this.typeDescription = typeDescription;
	}

}
