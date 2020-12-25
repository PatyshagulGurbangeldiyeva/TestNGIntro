package com.class01;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import com.utils.CommonMethods;
import com.utils.ConfigsReader;

public class TitleLogoLoginValidation extends CommonMethods {
	
//	Three Test cases
//	before: open browser, navigate to the website
//	1. Test Case: Title Validation
//	after: quit the browser
//	before: open browser, navigate to the website
//	2. Test Case: Logo Validation
//	after: quit the browser
//	before: open browser, navigate to the website
//	3. Test Case Valid Login
//	after: quit the browser
	
	@BeforeMethod
	public void openAndNavigate() throws InterruptedException {
		setUp();
		Thread.sleep(2000);
		
	}
	@AfterMethod
	public void quickBrowser() {
		tearDown();
	}
	

	
	@Test
	public void titleValidation() throws Exception {
		String expectedTitle="Human Management System";
		String actualTitle=driver.getTitle();
//		System.out.println(actualTitle);
		if (expectedTitle.equals(actualTitle)) {
			System.out.println("titleValidation passed");
		}else {
			System.out.println("titleValidation failed");
			throw new Exception(); // we are throwing exception in order to see that the test failed in both in console and sout!!!
		}
	}
	
	@Test
	public void logoValidation() {
		WebElement logo=driver.findElement(By.xpath("//div[@id='divLogo']/img"));
		boolean isDislpayed=logo.isDisplayed();
		if (isDislpayed) {
			System.out.println("logo validation passed");
		}else {
			System.out.println("logo validation failed");
			
			
		}
	}
	
	@Test
	public void loginValidation() {
		WebElement userName=driver.findElement(By.id("txtUsername"));	
		sendText(userName, ConfigsReader.getProperty("username"));
		
		WebElement password=driver.findElement(By.id("txtPassword"));	
		sendText(password, ConfigsReader.getProperty("password"));
		
		WebElement login=driver.findElement(By.id("btnLogin"));
		click(login);
	}

}
