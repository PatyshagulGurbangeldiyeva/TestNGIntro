package com.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class HandlingTabsAction {
	
	@Test
		public void handleTab() {
		
		System.setProperty("webdriver.chrome.driver","/Users/vepagurbangeldiyev/eclipse-workspace/Selenium/drivers/chromedriver");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.google.com");
		driver.manage().window().fullscreen();
		
		WebElement gmail=driver.findElement(By.linkText("Gmail"));
		WebElement images=driver.findElement(By.className("gb_g"));
		
		Actions action= new Actions (driver);
		
		action.keyDown(Keys.COMMAND).click(gmail).keyUp(Keys.COMMAND).build().perform();
		}
	

}
