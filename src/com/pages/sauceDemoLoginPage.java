package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.CommonMethods;

public class sauceDemoLoginPage extends CommonMethods {

	@FindBy (id="user-name")
	public  WebElement userNameTextBox;
	
	
	@FindBy (id="password")
	public WebElement passwordTextBox;
	
	@FindBy (xpath="//input[@class='btn_action']")
	public WebElement loginBtn;
	
	@FindBy(xpath="//div[@class='product_label']")
	public WebElement headerText;
	
	@FindBy(xpath="//h3[contains(text(),'Epic sadface']") // if we cannot login we see the error msg
	public WebElement errorMsg;
	
	public sauceDemoLoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
}
