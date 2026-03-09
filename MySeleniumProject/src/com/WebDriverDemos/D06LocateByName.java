package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D06LocateByName {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://practicetestautomation.com/practice-test-login/");
		
		WebElement txtUserName = driver.findElement(By.name("username"));
		txtUserName.sendKeys("invaliduser");
		WebElement txtPassword = driver.findElement(By.name("password"));
		txtPassword.sendKeys("Password123");
		WebElement submitBtn = driver.findElement(By.id("submit"));
		submitBtn.click();
		WebElement errorMessage = driver.findElement(By.id("error"));
		String msg = errorMessage.getText();
		System.out.println("Error Message: " + msg);
		
		driver.close();
	}

}
