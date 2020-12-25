package com.class04;

import org.junit.Assert;
import org.testng.annotations.*;

public class ListenerDemo {
	
	@Test
	public void Test1() {
		System.out.println("Test1");
		Assert.assertTrue(true);
	}
	
	@Test
	public void Test2() {
		System.out.println("Test2");
		Assert.assertTrue(false);
	}

}
