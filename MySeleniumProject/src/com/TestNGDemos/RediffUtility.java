package com.TestNGDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RediffUtility {
	WebDriver driver;
	
	public void enterFullName(String fn) {
		driver.findElement(By.xpath("//input[@placeholder='Enter your full name']")).sendKeys(fn);
	}
	
	public void enterRediffId(String rid) {
		driver.findElement(By.xpath("//input[contains(@id, 'login')]")).sendKeys(rid);
	}
	
	public void enterPassword(String ps) {
		driver.findElement(By.xpath("//input[@id='newpasswd']")).sendKeys(ps);
		driver.findElement(By.xpath("//input[@id='newpasswd1']")).sendKeys(ps);
	}

}
