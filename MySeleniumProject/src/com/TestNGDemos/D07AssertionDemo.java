package com.TestNGDemos;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class D07AssertionDemo {
	WebDriver driver;

	String expUrl = "https://practicetestautomation.com/logged-in-successfully/", actUrl;
	
	@Test(dataProvider = "getLoginData")
	public void loginToPracticeTest(String un, String ps) throws InterruptedException {
		driver.findElement(By.name("username")).sendKeys(un);
		driver.findElement(By.name("password")).sendKeys(ps);
		driver.findElement(By.id("submit")).click();
		
		actUrl = driver.getCurrentUrl();
		
		//Assert.assertEquals(actUrl, expUrl, "Invalid Credentials!!!");
		//Assert.assertTrue(actUrl.equals(expUrl), "Invalid Credentials!!!");
		Assert.assertTrue(actUrl.contains("success"), "Invalid Credentials!!!");
	}

	@AfterMethod
	public void afterMethod() {
		if (driver.getCurrentUrl().contains("success")) {
			driver.findElement(By.partialLinkText("Log")).click();
			System.out.println("Test case pass");
		}
		else {
			System.out.println("Invalid credetionals!!! Test case fail!!!");
		}
	}


	@DataProvider
	public Object[][] getLoginData() {
		return new Object[][] {
			new Object[] { "student", "Password123" },
			new Object[] { "meghana", "meghana123" },
			new Object[] { "student", "Password123" },
			new Object[] { "dharmesh", "dharmesh123" },
			new Object[] { "student", "Password123" },
		};

		//Object[][]data = {{1, "a", 1.1}, {2, "b", 2.2}, {3, "c", 3.3}};
		//return data;
	}
	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://practicetestautomation.com/practice-test-login/");
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}
}
