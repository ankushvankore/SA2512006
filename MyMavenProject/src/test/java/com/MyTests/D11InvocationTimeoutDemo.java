package com.MyTests;

import org.testng.annotations.Test;

public class D11InvocationTimeoutDemo {
	@Test (invocationTimeOut = 3000)
	public void myTrialTest() throws InterruptedException {
		System.out.println("Test started!!!");
		
		Thread.sleep(2999);
		
		System.out.println("Test ended!!!");
	}
}
