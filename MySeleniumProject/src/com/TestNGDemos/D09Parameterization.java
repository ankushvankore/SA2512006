package com.TestNGDemos;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class D09Parameterization {
	WebDriver driver;
	JavascriptExecutor js;
	
	@Parameters({"userName", "password"})
	@Test
	public void loginToExpandTesting(String un, String ps) {
		driver.findElement(By.id("username")).sendKeys(un);
		driver.findElement(By.id("password")).sendKeys(ps);
		driver.findElement(By.id("submit-login")).submit();
	}

	@AfterMethod
	public void logout(){
		if(driver.getCurrentUrl().contains("secure")) {
			//js.executeScript("window.scrollBy(0,300)", "");
			
			WebElement logoutLink = driver.findElement(By.linkText("Logout"));
			js.executeScript("arguments[0].scrollIntoView()", logoutLink);
			js.executeScript("arguments[0].click()", logoutLink);
			//Scroll till this control
			logoutLink.click();
		}
	}
	@BeforeTest
	public void beforeTest() {
		Map<String, Object>pref = new HashMap<>();
		pref.put("profile.credentials_enable_serve", false);
		pref.put("profile.password_manager_leak_detection", false);
		ChromeOptions op = new ChromeOptions();
		op.setExperimentalOption("prefs", pref);
		
		driver = new ChromeDriver(op);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://practice.expandtesting.com/login");
        js = (JavascriptExecutor)driver;
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
