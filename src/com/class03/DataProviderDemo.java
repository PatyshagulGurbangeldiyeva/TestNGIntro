package com.class03;

import org.testng.Assert;
import org.testng.annotations.*;

import com.utils.CommonMethods;

public class DataProviderDemo extends CommonMethods{
	

	
	
	@Test(dataProvider="getData")
	public void login(String username, String password, int age) {
		System.out.println(age);
		sendText(login.username, username);
		sendText(login.password,password);
		click(login.loginBtn);
		
		boolean isDisplayed=dashboard.welcome.isDisplayed();
		
		Assert.assertTrue(isDisplayed, "welcome msg is not displayed");
	}


	@DataProvider
	public Object [][]getData (){
		/*this is like doing the following three steps
		 * login("Admin","Hum@nhrm123",23);
		 * login("Syntax","Syntax123!",25);
		 * login("SyntaxUser","Syntax123!",20);
		 * 
		 * the number of rows will decide how many times test will run
		 * the columns of each row are bound/pass as parameter to TestCase/Testmethod
		 */
		Object [][]data= {
				{"Admin","Hum@nhrm123",23},
				{"Syntax","Syntax123!",25},
				{"SyntaxUser","Syntax123!",20},
		};
		return data;
	}


}
