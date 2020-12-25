package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.DashBoardPageElements;
import com.pages.LoginPageElements;
import com.utils.CommonMethods;
import com.utils.ConfigsReader;

public class AddEmployeeTest extends CommonMethods {

	// we added @befor and @after in Base class as we are repeating it many times
	
//	@BeforeMethod
//	public void OpenBrowser() {
//		setUp();
//		
//		
//	}
//
//
//	@AfterMethod
//	public void closeBrowser() {
//		tearDown();
//	
//}
	
	@Test 
	public void addEmployeePage() {
		LoginPageElements login=new LoginPageElements();
		
		login.username.sendKeys(ConfigsReader.getProperty("username"));
		login.password.sendKeys(ConfigsReader.getProperty("password"));
		login.loginBtn.click();
		
		DashBoardPageElements board=new DashBoardPageElements();
		board.PIM.click();
		click(board.addEmp);
		
		
	}
	
}
