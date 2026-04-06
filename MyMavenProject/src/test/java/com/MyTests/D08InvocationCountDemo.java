package com.MyTests;

import org.testng.annotations.Test;

public class D08InvocationCountDemo {
	@Test (invocationCount = 5)
	public void myTest() {
		System.out.println("myTest executed!!!");
	}
}
