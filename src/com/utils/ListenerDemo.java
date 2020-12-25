package com.utils;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerDemo implements ITestListener{
	// we create listeners in order to help us in advancing what test pass what failed and skipped

	public void onTestStart(ITestResult result) { //--> it describes the result of the test
		System.out.println("test started "+result.getName());
	
	}
	
	public void onTestSuccess (ITestResult result) {
		System.out.println("Test case Passed "+result.getName());
	}
	
	public void onTestFailure (ITestResult result) {
		System.out.println("Test case failed "+result.getName());
	}
	
	public  void onTestSkipped(ITestResult result) {
		System.out.println("Test case skipped "+result.getName());
	}
	}

