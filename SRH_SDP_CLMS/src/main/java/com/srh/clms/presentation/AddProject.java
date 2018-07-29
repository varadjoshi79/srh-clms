package com.srh.clms.presentation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;

import com.srh.clms.entities.*;
import com.srh.clms.businesslogic.*;

public class AddProject {

	public void addProject(DetailInfo info) throws ParseException, InterruptedException {

		Project project = new Project();
		Builder builder = new Builder();
		BusinessLogicLayer bll = new BusinessLogicLayer();
		Scanner sc = new Scanner(System.in);
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		DateFormat formatterTime = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		Date startDate;
		String strStratDate;
		Date endDate;
		String strEndDate;
		int amount = 0;
		int laborCount = 0;
		Date createDate = new Date();
		String createdBy;
		String location;
		String projectName;
		String projectDescription;
		String projectStatus;

		System.out.println("*********************Adding Project****************** ");

		int builderid = info.getInfoId();

		System.out.println("Enter Project Name ");
		projectName = sc.next();
		System.out.println("Enter Project Description:");
		projectDescription = sc.next();
		
		projectStatus = "NOT STRT";
		
		System.out.println("Enter Start date of Project");
		strStratDate = sc.next();
		startDate = formatter.parse(strStratDate);
		

		System.out.println("End date of Project");
		strEndDate = sc.next();
		endDate = formatter.parse(strEndDate);

		System.out.println("Enter amount of project");
		amount = sc.nextInt();

		System.out.println("Enter location of Project");
		location = sc.next();
		
		project.setProjectName(projectName);
		project.setProjectdescription(projectDescription);
		project.setStatus(projectStatus);
		project.setProjectStartDate(startDate);
		project.setProjectEndDate(endDate);
		project.setAmount(amount);

		project.setLocation(location);
		project.setProjectCreator(info.getFirstName());
		project.setProjectCreationDate(createDate);
		
		builder.setInfoId(info.getInfoId());
		
		bll.addProject(project, builder);
		System.out.print("Project added");
	}
}
