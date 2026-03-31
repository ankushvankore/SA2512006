package com.MyTests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class D03SimpleExtentReportDemo {

	public static void main(String[] args) {
		//Extent Report - Is third party open source tool / library for creating HTML report
		
		ExtentSparkReporter htmlReport = new ExtentSparkReporter("SimpleReport.html");
		//This object represents report file
		ExtentReports report = new ExtentReports();
		//This object represents the report
		ExtentTest test;
		//Represents the test case
		
		report.attachReporter(htmlReport);
		//Attaching the report with HTML file
		
		WebDriver driver;
		
		//Add environment details
		report.setSystemInfo("Machine", "Dell");
		report.setSystemInfo("Application", "Google");
		report.setSystemInfo("Browser", "Google Chrome");
		report.setSystemInfo("User Name", "Varsha");
		report.setSystemInfo("Operating System", "Windows 10");
		
		//Configure report with the look and feel prospective
		htmlReport.config().setDocumentTitle("My Simple Report");
		htmlReport.config().setReportName("Google Test Report");
		htmlReport.config().setTimeStampFormat("dd-MMM-yyyy");
		htmlReport.config().setTheme(Theme.STANDARD);
		
		test = report.createTest("Google Title Test");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://google.com");
		System.out.println("Title: " + driver.getTitle());
		
		driver.close();
		
		test.log(Status.PASS, MarkupHelper.createLabel("Google Title Test", ExtentColor.GREEN));
		
		//------------------------------------------------------------------//
		
		test = report.createTest("Google Search Test");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://google.com");
		
		driver.findElement(By.name("q")).sendKeys("Maven Dependency", Keys.ENTER);
		
		driver.close();
		
		test.log(Status.FAIL, MarkupHelper.createLabel("Google Search", ExtentColor.RED));
		
		report.flush();	//This will generate the report file
	}

}
