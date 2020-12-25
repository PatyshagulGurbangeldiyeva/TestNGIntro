package com.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.Base;

public class PersonalDetailsPageElements {
	
	@FindBy(id="personal_cmbNation")
	WebElement nationakityDD;
	
	@FindBy(name="personal[optGender]")
	public List <WebElement> genderRadioGroup;
	
	@FindBy(xpath = "//div[@id='pdMainContainer']/div[1]/h1")
	public WebElement lblPersonalDetails;

	@FindBy(id = "personal_txtEmployeeId")
	public WebElement employeeId;
	
	public PersonalDetailsPageElements() {
		PageFactory.initElements(Base.driver, this); // initializing instance variables in this class
	}

}
