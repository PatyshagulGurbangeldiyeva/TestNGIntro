package com.class002;

import org.testng.annotations.Test;

public class Task1Annotiatins {
	/*Create a class TaskOne that has 5 test methods named:
		firstMethod
		firstMethod1
		secondMethod
		thirdMethod
		fourthMethod
		
		And each of them printing the method name
		Run and observe results
		Then, add the needed attributes to print the following result:
		fourthMethod
		thirdMethod
		secondMethod
		firstMethod
		*/
	
	@Test(priority=3)
	public void method1() {
		System.out.println("method1");
	}
	
	@Test(priority=2)
	public void method2() {
		System.out.println("method2");
		
	}
	
	@Test (priority=1)
	public void method3() {
		System.out.println("method3");
		
	}
	
	@Test
	public void method4() {
		System.out.println("method4");
		
	}
	
	

}
