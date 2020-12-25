package com.test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.utils.CommonMethods;

public class sauceParameterDemo extends CommonMethods{
	
	@Parameters ({"username" , "password"})

	@Test 
	
	public void login (String username, String password) {
		sendText(sauceDemo.userNameTextBox, username);  //sauceDemo is a variable that we initialized in initialize Page
		sendText(sauceDemo.passwordTextBox, password);
		click(sauceDemo.loginBtn);
		wait(3);
	}

}
