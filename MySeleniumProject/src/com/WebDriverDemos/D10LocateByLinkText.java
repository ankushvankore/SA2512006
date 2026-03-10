package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D10LocateByLinkText {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://practicetestautomation.com/practice-test-login/");

		WebElement txtUserName = driver.findElement(By.name("username"));
		txtUserName.sendKeys("student");
		WebElement txtPassword = driver.findElement(By.name("password"));
		txtPassword.sendKeys("Password123");
		WebElement submitBtn = driver.findElement(By.id("submit"));
		submitBtn.click();

		String url = driver.getCurrentUrl();
		if (url.contains("successfully")) {
			WebElement logoutLink = driver.findElement(By.linkText("Log out"));
			String text = logoutLink.getText();
			System.out.println("Text on the link: " + text);
			String href = logoutLink.getAttribute("href");
			System.out.println("href: " + href);
			logoutLink.click();
		}
		else {
			System.out.println("Invalid creadtionals!!!");
		}
		
	}

}
