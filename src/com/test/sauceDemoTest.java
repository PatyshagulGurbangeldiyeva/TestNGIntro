package com.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pages.sauceDemoLoginPage;
import com.utils.CommonMethods;

public class sauceDemoTest extends CommonMethods {
	
	
	@DataProvider (name="DataProvider")
	public Object [][] getData(){
//		Object [][]data= {
//				{"standard_user", "secret_sauce"},
//				{"locked_out_user","secret_sauce"},
//				{"problem_user","secret_sauce"},
//				{"performance_glitch_user","secret_sauce"}
//				};
		
		
		// second way
		Object [][]data=new Object[4][2]; // here we idetntify the size
		data [0][0]= "standard_user"; // here index starts with zero
		data [0][1]= "secret_sauce";
				
		data [1][0]="locked_out_user";
		data[1][1]="secret_sauce";
		
		data [2][0]="problem_user";
		data [2][1]= "secret_sauce";
		
		data [3][0]= "performance_glitch_user";
		data [3][1]="secret_sauce";
		
		return data;
	}
	
										// developers or managers will decide which group will be our test
	@Test (dataProvider="DataProvider", groups="sprint")
	public void loginToSauceDemo(String username, String password) {
		sendText(sauceDemo.userNameTextBox, username);  //sauceDemo is a variable that we initialized in initialize Page
		sendText(sauceDemo.passwordTextBox, password);
		click(sauceDemo.loginBtn);
		wait(3);
		
		// when we login manually we have already known that the other usernames are not login , and coz of that i cannot reach to next pg
		// and see the element is displayed
		if(username.equalsIgnoreCase("locked_out_user")) {
			Assert.assertTrue(sauceDemo.headerText.isDisplayed()); // if the element is not diplayed the test will fail
		}else {
			Assert.assertTrue(sauceDemo.errorMsg.isDisplayed()); // if the element is not displayed we will se error msg
		}
		
		
	}
	
	

}
