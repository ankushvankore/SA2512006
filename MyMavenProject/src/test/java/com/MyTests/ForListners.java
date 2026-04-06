package com.MyTests;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ForListners implements ITestListener {
	
	public void onStart(ITestContext result) {
		System.out.println("Test started");
	}

	public void onFinish(ITestContext result) {
		System.out.println("Test ends");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test: " + result.getName() + " Fail");
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test: " + result.getName() + " Skipped");
	}

	public void onTestStart(ITestResult result) {
		System.out.println("Test: " + result.getName() + " Started");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test: " + result.getName() + " Pass");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

}
