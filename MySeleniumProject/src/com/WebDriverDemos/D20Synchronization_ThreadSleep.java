package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class D20Synchronization_ThreadSleep {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		// Login
		Thread.sleep(5000);
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.className("oxd-button")).click();

		// Logout
		Thread.sleep(5000);
		String url = driver.getCurrentUrl();
		if (url.contains("dashboard")) {
			driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/i")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Logout")).click();
		}
		else {
			System.out.println("Invalid creadtionals!!!");
		}
		driver.close();
	}

}
