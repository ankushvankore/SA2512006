package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D05LocateById {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://practicetestautomation.com/practice-test-login/");
		
		WebElement txtUserName = driver.findElement(By.id("username"));
		//Please locate a control whose id is username and store this control in txtUserName object
		txtUserName.sendKeys("student");
		WebElement txtPassword = driver.findElement(By.id("password"));
		txtPassword.sendKeys("wrongpassword");
		WebElement submitBtn = driver.findElement(By.id("submit"));
		submitBtn.click();
		
		WebElement errorMessage = driver.findElement(By.id("error"));
		String msg = errorMessage.getText();
		System.out.println("Error Message: " + msg);
		
		if(msg.equals("Your password is invalid!"))
			System.out.println("Test case pass");
		else
			System.out.println("Test case fail");
		
		driver.close();
	}
}
