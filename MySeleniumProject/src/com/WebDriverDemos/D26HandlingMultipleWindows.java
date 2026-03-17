package com.WebDriverDemos;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class D26HandlingMultipleWindows {

	/*
	 * Please note
	 * For handling the multiple windows and handling multiple tabs same technique is used 
	 */
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.naukri.com/");
		
		//Click on Remote
		//driver.findElement(By.xpath("//span[text()='Remote']")).click();
		driver.findElement(By.xpath("//span[contains(text(), 'Remote')]")).click();
		System.out.println("Title: " + driver.getTitle());
		
		Set<String>windows = driver.getWindowHandles();
		//System.out.println(windows);
		
		Object[] winArray = windows.toArray();
		//System.out.println(winArray[0] + " " + winArray[1]);
		
		String homePage = winArray[0].toString();
		String newPage = winArray[1].toString();
		//Switch to the newPage
		driver.switchTo().window(newPage);
		Thread.sleep(2000);
		System.out.println("Title: " + driver.getTitle());
		
		//Click on Work from office checkbox
		driver.findElement(By.xpath("//*[@id=\"search-result-container\"]/div[1]/div[1]/div/div/div[2]/div[1]/div[2]/div[1]/label/i")).click();
		Thread.sleep(2000);
		
		//Go back to home page
		driver.switchTo().window(homePage);
		
		//Click on Login button
		driver.findElement(By.linkText("Login")).click();
		
		driver.quit();
	}

}
