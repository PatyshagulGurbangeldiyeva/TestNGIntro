package com.utils;

import com.pages.AddEmployeePageElements;
import com.pages.DashBoardPageElements;
import com.pages.LoginPageElements;
import com.pages.PersonalDetailsPageElements;

import com.pages.sauceDemoLoginPage;

public class PageInitializer extends Base{
	
	// the goal of this class is to initialize all the pages
	
	// we have:
	/* login page
	 * dashboard page
	 * personal details page
	 * add employee page
	 * sauce login page
	 */
	
	public static LoginPageElements login; // here I made instance variables in order to get them from other classes
	public static DashBoardPageElements dashboard;
	public static AddEmployeePageElements addEmp;
	public static PersonalDetailsPageElements pdetails;
	public static sauceDemoLoginPage sauceDemo;

	
	public static void initialize() {
	
		login= new LoginPageElements();
		dashboard=new DashBoardPageElements();
		addEmp= new AddEmployeePageElements();
		pdetails=new PersonalDetailsPageElements();
		sauceDemo=new sauceDemoLoginPage();
	}

}
