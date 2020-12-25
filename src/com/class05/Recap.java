package com.class05;

import org.testng.annotations.Test;

public class Recap {
@Test
public void arrayRecap() {
	Object [][] data= new Object [2][3];
	data [0][0]=12;  // colums
	data[0][1]=13;  // colums
	data [0][2]=14;  //colums
	
	data [1][0]=100;
	
	System.out.println(data [1][1]); // you will execute null as [2]-->rows [3]--->colums
										// we did not add to that row and col the data so it will be empty 
									// and execution will be null
}
}
