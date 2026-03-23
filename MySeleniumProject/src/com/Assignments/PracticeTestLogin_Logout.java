package com.Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PracticeTestLogin_Logout {
	WebDriver driver;

	@Test
	public void login1() {
		driver.findElement(By.name("username")).sendKeys("student");
		driver.findElement(By.name("password")).sendKeys("Password123");
		driver.findElement(By.id("submit")).click();
	}

	@Test
	public void login2() {
		driver.findElement(By.name("username")).sendKeys("student");
		driver.findElement(By.name("password")).sendKeys("Password123");
		driver.findElement(By.id("submit")).click();
	}

	@Test
	public void login3() {
		driver.findElement(By.name("username")).sendKeys("meghana");
		driver.findElement(By.name("password")).sendKeys("meghana123");
		driver.findElement(By.id("submit")).click();
	}

	@AfterMethod
	public void logout() {
		if (driver.getCurrentUrl().contains("success")) {
			driver.findElement(By.partialLinkText("Log")).click();
			System.out.println("Test case pass");
		}
		else {
			System.out.println("Invalid credetionals!!! Test case fail!!!");
		}
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
