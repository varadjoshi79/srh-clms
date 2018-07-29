package com.srh.clms.presentation;

import com.srh.clms.businesslogic.BusinessLogicLayer;
import com.srh.clms.entities.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class AddWork {

	public void addWork(Project project) throws ParseException {

		Work work = new Work();
		BusinessLogicLayer bll = new BusinessLogicLayer();
		Scanner sc = new Scanner(System.in);
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");

		int workType;
		String strStartDate;
		Date sDate;
		String strEndDate;
		Date eDate;
		int reqPeople;
		int noOfDays;
		boolean flag = true;
		int labourRate;

		System.out.println("*******************Adding new  work***************************  ");
		System.out.println(" Select type of work 1.Electrical 2.Civil 3.Painter 4.Mechanical");
		workType = sc.nextInt();
		if (workType == 1) {
			work.setWorkDescp("Electrical");
		}
		if (workType == 2) {
			work.setWorkDescp("Civil");
		}
		if (workType == 3) {
			work.setWorkDescp("Painter");
		}
		if (workType == 4) {
			work.setWorkDescp("Mechanical");
		}

		System.out.println("Enter start date of work (YYYY/MM/DD): ");
		strStartDate = sc.next();
		sDate = formatter.parse(strStartDate);

		System.out.println("Enter end date of work (YYYY/MM/DD): ");
		strEndDate = sc.next();
		eDate = formatter.parse(strEndDate);

		work.setWorkType(workType);
		work.setWorkStatus("Not Started");
		work.setStartDate(sDate);
		work.setEndDate(eDate);

		System.out.println("Enter number of labors required :");
		reqPeople = sc.nextInt();
		work.setReqPeople(reqPeople);

		noOfDays = calculateDays(sDate, eDate);
		work.setNoofdays(noOfDays);
		
		System.out.println("Enter the rate of labor :");
		labourRate=sc.nextInt();
		work.setLabourRate(labourRate);

		flag = bll.addWork(work, project);

		if (flag = true) {
			System.out.print("Work added Successfully");
		} else {
			System.out.println("Work can not be added");
		}

	}

	public int calculateDays(Date startDate, Date endDate) {
		Calendar startCal = Calendar.getInstance();
		startCal.setTime(startDate);

		Calendar endCal = Calendar.getInstance();
		endCal.setTime(endDate);

		int workDays = 0;

		if (startCal.getTimeInMillis() == endCal.getTimeInMillis()) {
			return 0;
		}

		if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
			startCal.setTime(endDate);
			endCal.setTime(startDate);
		}

		do {
			// excluding start date
			startCal.add(Calendar.DAY_OF_MONTH, 1);
			if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY
					&& startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
				++workDays;
			}
		} while (startCal.getTimeInMillis() < endCal.getTimeInMillis()); // excluding end date

		return workDays;
	}

}
