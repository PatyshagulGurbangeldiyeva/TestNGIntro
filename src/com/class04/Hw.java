package com.class04;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.CommonMethods;
import com.utils.ConfigsReader;
import com.utils.ExcelUtility;

public class Hw extends CommonMethods{
	
	/* open the browser
	 * navigate to hmr
	 * login into application
	 * add 5 different employees and create login credentials by providing
	 *  name
	 *  last name
	 *  username
	 *  password
	 *  
	 *  1. provide employee first name and last name
	 *  2. varify employee has been added susscesfully and take screenshot
	 *  (yu must have 5 different screenshots)
	 * 
	 * close the browser
	 * 
	 * specify group for this test case , add it into specific suite and execute from xml file
	 * 
	 */
	
	
	@Test(dataProvider="userDataFromExcel", groups= {"homework", "addEmp","regression"})
	public void test(String firstName, String lastName,String username,String password) {
		// first we need to  login into the page hrms
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));	
	
		// navigate to Add Employee page
		dashboard.navigateToAddEmployee();
		wait(1);
		
	// add emp info
		sendText(addEmp.firstName, firstName);
		sendText(addEmp.lastName,lastName);
		
		// get emp Id
		String expectedEmpId=addEmp.employeeId.getAttribute("value");
		System.out.println(expectedEmpId);
		
		//click on Login Details
		click(addEmp.checkBoxLoginDetails);
		wait(1);
		
		sendText(addEmp.username, username);
		sendText(addEmp.password, password);
		sendText(addEmp.confirmPassword, password);
		click(addEmp.saveBtn);
		wait(1);
		
		//validation
		waitForVisibility(pdetails.lblPersonalDetails);
		String actualEmpId=pdetails.employeeId.getAttribute("value");
		
		Assert.assertEquals(actualEmpId,  expectedEmpId, "employee ID did not match");
		
		// take screenshot
		takeScreenshot(firstName+"_"+lastName); // created a method in common method
		
	}
	
	@DataProvider (name="userData")
	public Object [][]getData(){
		Object data[][]= {
				{"Jane", "Smith","jane123","janeSmith"},
				{"Mary","En","mary123","maryEn"},
				{"Raj","Kapur","raj123","RajKapur"},
				{"Ali","Saglam","ali123","aliSaglam"},
				{"Alp","Yusup","alp123","alpYusup"},
		};
		return data;
	}
	
	@DataProvider (name="userDataFromExcel")
	public Object [][]getData2(){								// excel file name where it is     sheet name
		return ExcelUtility.excelIntoArray(System.getProperty("user.dir")+"/testData/Test.xlsx","Employee");
	}
	

}
