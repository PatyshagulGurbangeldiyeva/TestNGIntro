package com.class002;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.LoginPageElements;
import com.utils.CommonMethods;

public class HardAssertionDemo extends CommonMethods{
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
	
	//1st way
	//Assert.assertEquals(actualTitle, expectedTitle);
	
	//2nd way										// this is adding message
	Assert.assertEquals(actualTitle, expectedTitle, "title doesn't match");
	System.out.println("text after assertion");
	// if the assertion fail then the text after it in the same method will not be printed(executed)
	}
	
	@Test (priority=2, dependsOnMethods= {"titleValidation"})
	public void logoValidation() {
		LoginPageElements login=new LoginPageElements();
		boolean displayed=login.logo.isDisplayed();
		
		//1st way
//		Assert.assertEquals(displayed,true, "logo is not displayed");
		
		//2nd way
		Assert.assertTrue(displayed, "logo is not displayed");
		
	}
}
