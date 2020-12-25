package com.utils;

import java.util.concurrent.TimeUnit;

//import org.apache.commons.math3.analysis.function.Constant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public  class Base {
	
	public static WebDriver driver;
	
	@BeforeMethod (alwaysRun=true) // to make this method to run before every @Test method
	public  static WebDriver setUp() {// the goal of this method is to initialize our web driver
		
		
		
		// in order to access the method read in congigurationReader class
		// we call the method
		
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
		
		
		switch(ConfigsReader.getProperty("browser").toLowerCase()) { // the goal of the switch is to initialize the browser
		
		case "chrome":
			System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
			 driver=new ChromeDriver();
			break;
			
		case "firefox":
			System.setProperty("webdricer.gecko.driver", Constants.GECKO_DRIVER_PATH);
			driver=new FirefoxDriver();
			break;
			
			default : // there is nothing else so we can throw exceptions if any case they wrote the wrong browser name
				throw new RuntimeException ("browser is not supported");
				
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS); // this works with every findElement/findElements
		
		driver.get(ConfigsReader.getProperty("url"));
		
		PageInitializer.initialize(); // initialize all pg objects as part of setUp
		
		return driver;
		
	}
	
	@AfterMethod (alwaysRun=true) // to make this method to run after every @Test method
	public static void tearDown() { // this method is for closing the browser
		if (driver!=null) {
			driver.quit();
		}
	}

}
