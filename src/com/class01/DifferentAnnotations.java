package com.class01;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class DifferentAnnotations {
	
	@BeforeSuite
	public void beforeMethod() {
		System.out.println("Before suite");
	}
	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite");
	}
	
	@BeforeMethod
	public void beforeMetho1() {
		System.out.println("Before Method");
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("After method");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before class");
	}
	@AfterClass
	public void afterClass() {
		System.out.println("After class");
	}
	
	@Test
	public void test() {
		System.out.println("Actual test is running");
	}
	public void hi() { // it will not execute
		System.out.println("hi");
	}

}
