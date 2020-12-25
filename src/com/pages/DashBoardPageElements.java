package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.Base;
import com.utils.CommonMethods;

public class DashBoardPageElements extends CommonMethods {
	
	@FindBy(id="welcome")
	public WebElement welcome;
	
	@FindBy(xpath="//div[id='branding']/a[1]/img")
	public WebElement logo;
	
	@FindBy (xpath="//a[@id='menu_pim_addEmployee']")
	public WebElement addEmp;
	
	
	@FindBy(xpath = "//a[@id='menu_pim_viewPimModule']/b")
	public WebElement PIM;
	
	

	public DashBoardPageElements() {
		PageFactory.initElements(Base.driver, this);
	}
	public void navigateToAddEmployee() {
		jsClick(PIM);
		jsClick(addEmp);
	}

}
