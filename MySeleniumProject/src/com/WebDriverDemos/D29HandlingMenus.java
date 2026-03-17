package com.WebDriverDemos;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D29HandlingMenus {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		//Login
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.className("oxd-button")).click();

		List<WebElement>allMenus = driver.findElements(By.xpath("//ul[@class=\"oxd-main-menu\"]/li/a/span"));
		System.out.println("Total menus: " + allMenus.size());
		
		System.out.println("-------------- Menus on this page ------------");
		for(WebElement m : allMenus)
			System.out.println(m.getText());
		
		// Logout
		String url = driver.getCurrentUrl();
		if (url.contains("dashboard")) {
			driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/i")).click();
			driver.findElement(By.linkText("Logout")).click();
		}
		else {
			System.out.println("Invalid creadtionals!!!");
		}
		driver.close();
	}

}
