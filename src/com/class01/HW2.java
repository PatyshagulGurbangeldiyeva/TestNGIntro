package com.class01;

import org.testng.annotations.Test;

import com.utils.CommonMethods;
import com.utils.ConfigsReader;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;

public class HW2 extends CommonMethods {
	/* open chrome browser
	 * go to: http://166.62.36.207/humanresources/symfony/web/index.php/auth/login
	 * enter valid username 
	 * leave password field empty
	 * click on login button
	 * then verify message with text "password cannot be empty" is displayed
	 * close browser
	 */
	
	
  @Test
  public void invalidLogin() {
	  WebElement username=driver.findElement(By.id("txtUsername"));
		sendText(username, ConfigsReader.getProperty("username"));
		
	  WebElement loginBtn=driver.findElement(By.id("btnLogin"));
		click(loginBtn);
		
		WebElement message=driver.findElement(By.xpath("//div[@id='divLoginButton']//span"));
		  String messageText=message.getText();
//		  System.out.println(messageText);
		 
		  if (messageText.equalsIgnoreCase("Password cannot be empty")) {
			  System.out.println("test passed");
		  }
  }
  
 
  
  
  @BeforeMethod
  public void openBrowserAndNavigate() {
	  setUp();
  }
  
  

  @AfterMethod
  public void quitbrowser() {
	  tearDown();
  }

}
