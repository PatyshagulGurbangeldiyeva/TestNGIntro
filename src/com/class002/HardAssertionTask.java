package com.class002;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.DashBoardPageElements;
import com.pages.LoginPageElements;
import com.utils.CommonMethods;
import com.utils.ConfigsReader;

public class HardAssertionTask extends CommonMethods{
	
//	open application
//	varify logo is displayed
//	enter valid credentials
//	verify user successfully loged in, by verifying welcome message
	
	
	@BeforeMethod
	public void openBrowser() {
		setUp();
	}
	
	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}
	
	@Test()
	public void logoAndWelcomeValidation() {
		LoginPageElements login=new LoginPageElements();
		
		//logo assertion
		boolean displayed=login.logo.isDisplayed();
		Assert.assertTrue(displayed, "the logo is not displayed");
		
		//login assertion
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);
		
		//welcome msg assertion
		DashBoardPageElements dashboard=new DashBoardPageElements();
		boolean msgDisplayed=dashboard.welcome.isDisplayed();
		Assert.assertTrue(msgDisplayed,"welcome message is not displayed");
	}
	


}
