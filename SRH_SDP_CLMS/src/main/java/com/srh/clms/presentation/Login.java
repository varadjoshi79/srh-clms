package com.srh.clms.presentation;

import java.util.*;

import com.srh.clms.businesslogic.BusinessLogicLayer;
import com.srh.clms.entities.*;

public class Login {

	public static DetailInfo userLogin() {
		// TODO Auto-generated method stub

		String username;
		String password;
		Scanner sc = new Scanner(System.in);
		DetailInfo detailInfo = new DetailInfo();
		BusinessLogicLayer bll = new BusinessLogicLayer();

		System.out.print("Enter Username :");
		username = sc.next();
		System.out.print("Enter Password :");
		password = sc.next();

		detailInfo = bll.userLogin(username, password);

		if (detailInfo != null) {
			System.out.print("Login Successful as :" + detailInfo.getUserType());
		} else {
			System.out.print("Invalid credentials:");
		}

		System.out.println("Your are logged in as  " + detailInfo.getUserType() + "  Welome "
				+ detailInfo.getFirstName() + " " + detailInfo.getLastName());

		return detailInfo;

	}

}
