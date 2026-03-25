package com.TestNGDemos;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class D08TypesOfAssertion {
	@Test (priority = 1)
	public void passTest() {
		System.out.println("Test1 startd!!!");
		Assert.assertTrue(true);
		System.out.println("Test1 ends");
	}
	
	@Test (priority = 2)
	public void failTest() {
		System.out.println("Test2 startd!!!");
		Assert.assertTrue(false);
		System.out.println("Test2 ends");
	}
	
	@Test (priority = 3)
	public void passTestSoftAssert() {
		SoftAssert s1 = new SoftAssert();
		System.out.println("Test3 startd!!!");
		s1.assertTrue(true);
		System.out.println("Test3 ends");
	}
	
	@Test (priority = 4)
	public void failTestSoftAssert() {
		SoftAssert s1 = new SoftAssert();
		System.out.println("Test4 startd!!!");
		s1.assertTrue(false);
		System.out.println("Test4 ends");
		s1.assertAll();
	}
}
