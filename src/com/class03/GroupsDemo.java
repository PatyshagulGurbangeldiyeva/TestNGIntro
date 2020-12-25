package com.class03;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GroupsDemo {
	
	@BeforeClass (alwaysRun=true) // always run will make sure that this method will always execute
	public void beforeClass() {
		System.out.println("before class");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("after class");
	}
	
	
	@Test 
	public void test1() {
		System.out.println("test1");
	}
	
	@Test (groups="smoke")
	public void test2() {
		System.out.println("test2");
	}
	
	@Test (groups= {"regression"}) 
	public void test3() {
		System.out.println("test3");
	}
	
	@Test (groups= {"smoke","regression"})
	public void test4() {
		System.out.println("test4");
	}

	
	

}
