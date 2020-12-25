package com.TestNG.Review01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utils.CommonMethods;

public class sauceDemoTask extends CommonMethods{
	
	@BeforeMethod
	public void NavigateToUrl() {
		setUp();
		WebElement username=driver.findElement(By.id("user-name"));
		username.sendKeys("standard_user");
		WebElement password=driver.findElement(By.id("password"));
		password.sendKeys("secret_sauce");
		WebElement clickBtn=driver.findElement(By.className("btn_action"));
		clickBtn.click();
		wait(2);
	}
	
	@AfterMethod
	public void closeBrowser() {
		wait(2);
	tearDown();	
	}

	@Test
	public void verify() {
		String actualTitle="Products";
		WebElement display=driver.findElement(By.className("product_label"));
		String expectedTitle=display.getText();
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test
	public void select() {
		WebElement dropDown=driver.findElement(By.className("product_sort_container"));
//		dropDown.click();----> we dont need to click on it as we have select 
		wait(2);
		Select select=new Select(dropDown);
		select.selectByVisibleText("Price (low to high)"); // after we clicked it and drop down is still seen
													// how we can 
		
	}
}
