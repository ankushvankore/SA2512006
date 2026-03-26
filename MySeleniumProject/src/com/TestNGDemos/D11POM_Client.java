package com.TestNGDemos;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import graphql.Assert;

public class D11POM_Client {
	WebDriver driver;
	RediffUtility r1;

	@Test
	public void register1() throws InterruptedException {
		r1.enterFullName("Sapana Jangali");
		r1.enterRediffId("sapanaj");
		r1.enterPassword("sapana@123");
		r1.setBirthDate("20", "SEP", "2000");
		String msg = r1.checkAvailablity();

		Assert.assertTrue(msg.contains("Yippie"));
	}

	@Test
	public void register2() throws InterruptedException {
		r1.enterFullName("Mehghana Ram");
		r1.enterRediffId("meghana9874587458");
		r1.enterPassword("meghana@123");
		r1.setBirthDate("21", "MAY", "2000");
		String msg = r1.checkAvailablity();

		Assert.assertTrue(msg.contains("Yippie"));
	}

	@BeforeMethod
	public void refreshPage() throws InterruptedException {
		Thread.sleep(2000);
		driver.navigate().refresh();
	}

	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");

		r1 = new RediffUtility(driver);
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
