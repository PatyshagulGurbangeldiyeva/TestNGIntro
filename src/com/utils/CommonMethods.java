package com.utils;

import java.io.File;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods extends PageInitializer{ // we extended to Base class as there is a driver browser method

// we are going to develop the common method that will 
	//be accept by the same name and 
	//available entire the project
	
	
	/**
	 * Method that clears and sends keys to the textBox
	 * @param element
	 * @param text
	 */
	public static void sendText(WebElement element, String text) { // this method is for working with any WebElement
		
		element.clear();
		element.sendKeys(text);
		
	}
	
	/**
	 * method will click radio box
	 * @param radioOrCheckBox
	 * @param value
	 */
	//WORKING WITH RADIO BUTTON OR CHECKBOX
																				// the value name of rb or checkbox
	public static void clickRadioOrCheckbox(List <WebElement> radioOrCheckBox,String value ) {
		String actualValue;
		for (WebElement roc:radioOrCheckBox) {
			
			actualValue=roc.getAttribute("Value").trim(); // we trimed it in case may be there is space in value
			
			if (roc.isEnabled()&& actualValue.equalsIgnoreCase(value)) {
				roc.click();
				break;
			}
		}		
	}
	

	//WORKING HANDLING WITH DROP DOWN
	
	/**
	 * this method handling drop down and selects value
	 * @param element
	 * @param textToSlelect
	 */
	// using select type
	public static void selectDdValue(WebElement element, String textToSlelect) {
		try {
			Select select=new Select(element);	
			List <WebElement> options=select.getOptions();
			for (WebElement el:options) {
				String elText=el.getText();
				if(elText.equalsIgnoreCase(textToSlelect)) {
					select.selectByVisibleText(textToSlelect); // you can use click() too.
					break;
				}	
			}
			
		}catch (UnexpectedTagNameException ute){
			ute.printStackTrace();
		}	
	}
	
	
	/**
	 * method selects value from drop down and selects it by index
	 * @param element
	 * @param index
	 */
	// selecting value by using index
	public static void selectDdValue(WebElement element, int index) { // using index is our last choice where we don't have value and etc
		try {
			Select select=new Select (element);
			List <WebElement> options=select.getOptions();
			
			int size=options.size();
			
			if (size>index) {
				select.selectByIndex(index);
		}
	}catch (NoSuchElementException e) {
		
		e.printStackTrace();
		
		}
	}
	
	
	
	// HANDLING ALEERTS
	
	/**
	 * method handles with alert and access it
	 */
	//access alert
	public static void alertHandle() {
		try {
			Alert alert=driver.switchTo().alert();
			alert.accept();
		}catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * method handles with alert and dismiss alert
	 */
	//dismiss alert
	public static void dismissAlert() {
		try {
			Alert alert=driver.switchTo().alert();
			alert.dismiss();
		}catch(NoAlertPresentException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * method handling alert and getting text
	 * @return
	 */
	// getting alert text
	public static String getAlertText() {
		String alertText=""; // as it is local variable it is inside the method so we need to initialize it!!!!
		try {
			Alert alert=driver.switchTo().alert();
	//		return alert.getText();   //-----> we can write it here if we write her then we need to add to cstch method the return typ
		}catch(NoAlertPresentException e) {
			e.printStackTrace();
	//		return null;           // if we have return type in try block we need to add it here too. or just can be used outside the try and catch method
		}
	return alertText;	
	}
	
	/**
	 * method used to switch to frame by using name or id
	 * @param nameOrId
	 */
	public static void switchToFrame(String nameOrId) {
		try {
			driver.switchTo().frame(nameOrId);
		}catch(NoSuchFrameException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * method used to switch to frame by webElement argument
	 * @param element
	 */
	public static void switchToFrame(WebElement element) {
		try {
			driver.switchTo().frame(element);
			
		}catch(NoSuchFrameException e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * method used to switch to frame by index
	 * @param index
	 */
	public static void switchToFrame(int index) {
		try {
			driver.switchTo().frame(index);
			
		}catch(NoSuchFrameException e) {
			e.printStackTrace();
		}
	}
	
	
	public static WebDriverWait getWaitObject() {
	
			WebDriverWait wait=new WebDriverWait(driver, Constants.EXPLICIT_WAIT_TIME);
			return wait;
		}
	
	
	public static void waitForClickibility(WebElement element) {
		getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	public static void click(WebElement element) { //waiting till the element will be clickble
		waitForClickibility(element);
		element.click();
	}
	
	
	public static WebElement waitForVisibility(WebElement element) { // waiting until image or element will be visible
		return getWaitObject().until(ExpectedConditions.visibilityOf(element));
	}
	
	
	
	/**
	 * Method switches focus to child window
	 */
	public static void switchToChildWindow() {
		String mainWindow=driver.getWindowHandle();
		Set<String> windows=driver.getWindowHandles();
		for (String window:windows) {
			if (!window.equals(mainWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}
	}
		
		public static JavascriptExecutor getJSObject() {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			return js;
		}
	
	
	
		public static void jsClick(WebElement element) {
			getJSObject().executeScript("argument[0].click()", element);
			
		}
		
		
		public static void scrollToElement(WebElement element) {
			getJSObject().executeScript("arguments[0].scrollIntoView(true);", element);
		}
		
		public static void scrollDown(int pixel) {
			getJSObject().executeScript("window.scrollBy(0,"+pixel+")");
		}
		
		public static void scrollUp(int pixel) {
			getJSObject().executeScript("window.scrollBy(0,-"+pixel+")");
		}
		
		public static void wait(int second) {
			try {
				Thread.sleep(second*1000);
			}catch(InterruptedException e) {
				e.getStackTrace();
			}
		}
		
		public static void isDisplayed(WebElement element) {
			boolean displayed=element.isDisplayed();
			String text=element.getText();
			
			if (displayed) {
				System.out.println("the logo is "+text+"is displayed");
			}else {
				System.out.println("the logo is not displayed");
			}
			
		}
		
		/**
		 * method takes a screenShot
		 * @param fileName
		 */
		
		public static void takeScreenshot(String fileName) {
			TakesScreenshot ts=(TakesScreenshot) driver;
			File file=ts.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(file, new File("screenshot/"+fileName+".png"));
			}catch(Exception ex) {
				System.out.println("cannot take a screenshot");
			}
		
			
		}
		
	}
	
	
	
	
	

