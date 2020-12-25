package com.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utils.CommonMethods;
import com.utils.ConfigsReader;

public class HW1 extends CommonMethods  {
	
	/* open chrome browser
	 * go to: http://166.62.36.207/humanresources/symfony/web/index.php/auth/login
	 * enter valid username and password
	 * click on login button
	 * then varify syntax logo is displayed
	 * close browser
	 */
	
	@BeforeMethod
	public void openBrowser() {
		setUp();
	}
	
	
	@Test
	public void loginValidation() {
		
		WebElement username=driver.findElement(By.id("txtUsername"));
		sendText(username, ConfigsReader.getProperty("username"));
		
		WebElement password=driver.findElement(By.id("txtPassword"));
		sendText(password,ConfigsReader.getProperty("password"));
		
		WebElement loginBtn=driver.findElement(By.id("btnLogin"));
		click(loginBtn);
	}

	@Test
	public void logoValidation() {
		WebElement logo=driver.findElement(By.xpath("//div[@id='divLogo']/img"));
		if (logo.isDisplayed()) {
			System.out.println("the logo is dislpayed");
		}else {
			System.out.println("the logo is not displayed");
		}
	}
	
	@AfterMethod
	public void quit(){
		tearDown();
	}
}
