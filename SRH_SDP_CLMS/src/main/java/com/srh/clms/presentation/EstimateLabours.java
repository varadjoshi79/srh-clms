package com.srh.clms.presentation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.*;

public class EstimateLabours {

	Scanner sc = new Scanner(System.in);

	int workBudget;
	float labourRate;
	int labourCount;
	int days;
	Date startDate;
	String strStratDate;
	Date endDate;
	String strEndDate;

	public int labourCount() throws ParseException {

		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		System.out.println("Estimating Laour requirement for your work");

		System.out.println("Enter Budget for your work");
		workBudget = sc.nextInt();
		System.out.println("Enter the labor rate per hour");
		labourRate = sc.nextFloat();

		System.out.print("Enter start date of work YYYY/MM/DD");
		strStratDate = sc.next();

		System.out.print("Enter end date of work YYYY/MM/DD");
		strEndDate = sc.next();

		startDate = formatter.parse(strStratDate);
		endDate = formatter.parse(strEndDate);

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

		labourCount = (workBudget / (Math.round(labourRate * 8) * (workDays)));
		System.out.println("Your work required " + labourCount + " labours");

		return labourCount;

	}

}
