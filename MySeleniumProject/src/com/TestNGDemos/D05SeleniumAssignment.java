package com.TestNGDemos;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class D05SeleniumAssignment {
	WebDriver driver;
	
	@Test (priority = 1, groups = "CoreLinks")
	public void testDownloadLink() {
		driver.findElement(By.partialLinkText("Downloads")).click();
		Assert.assertTrue(driver.getTitle().contains("Downloads"));
	}
	
	@Test (priority = 2, groups = "CoreLinks")
	public void testDocumentationLink() {
		driver.findElement(By.partialLinkText("Document")).click();
		Assert.assertTrue(driver.getTitle().contains("Automation"));
	}
	
	@Test (priority = 3, groups = "AdditionalLinks")
	public void testProjectsLink() {
		driver.findElement(By.partialLinkText("Projects")).click();
		Assert.assertTrue(driver.getTitle().contains("Project"));
	}
	
	@Test (priority = 4, groups = "AdditionalLinks")
	public void testSupportLink() {
		driver.findElement(By.partialLinkText("Support")).click();
		Assert.assertTrue(driver.getTitle().contains("Support"));
	}

	@BeforeMethod (alwaysRun = true)
	public void beforeMethod() {
		driver.get("https://www.selenium.dev/");
		System.out.println("Title: " + driver.getTitle());
	}

	@AfterMethod (alwaysRun = true)
	public void afterMethod() {
		System.out.println("Title: " + driver.getTitle());
	}

	@BeforeTest (alwaysRun = true)
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterTest (alwaysRun = true)
	public void afterTest() {
		driver.close();
	}

}
