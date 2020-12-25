package com.class002;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.pages.DashBoardPageElements;
import com.pages.LoginPageElements;
import com.utils.CommonMethods;

public class SoftAssertion extends CommonMethods {
	
	
	@BeforeMethod
	public void openBrowserNavigat() {
		setUp();
	}
	
	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}
	
	@Test
	public void titleValidation() {
	String expectedTitle="Human Management System";
	String actualTitle=driver.getTitle();		
	
	// we use assertion in order to get thrown, as the result is not expected then it will throw
	//	an exception so testing will not be
	
	//1st way of using hard assertion
	//Assert.assertEquals(actualTitle, expectedTitle);
	
	//2nd way of using hard assertion				// this is adding message
	Assert.assertEquals(actualTitle, expectedTitle, "title doesn't match");
	System.out.println("text after assertion");
	// if the assertion fail then the text after it in the same method will not be printed(executed)
	// it is a hard assertion. if the test will fail the rest of the code will not be executed
	}
	
	@Test (priority=2, dependsOnMethods= {"titleValidation"})
	public void logoValidation() {
		LoginPageElements login=new LoginPageElements();
		boolean displayed=login.logo.isDisplayed();
		
		// failing on purpuse
		displayed=false;
		
		// if we do hard assertion the code will not continue
		//  if we use soft assert the rest of the code will be executed--> in order to use
		// soft assert we need to create an obj of softAssert
		
		SoftAssert soft=new SoftAssert();
		soft.assertTrue(displayed,"logo is not displayed");
		
	
		DashBoardPageElements dashboard=new DashBoardPageElements();
		boolean msgDisplayed=dashboard.welcome.isDisplayed();
		
		soft.assertTrue(msgDisplayed, "msg is not displayed");
		
		// this will check if all soft assertions passed or failed
		
		soft.assertAll();
	}	
	
}


