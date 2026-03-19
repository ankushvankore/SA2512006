package com.WebDriverDemos;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D37HandlingPaginationTable {

	/*
	 * 1. Display total no of pages
	 * 2. Click on each page no (Open each page) 
	 * 3. Display no of rows on each page
	 * 4. Select every checkbox on the each page
	 */
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://testautomationpractice.blogspot.com/?m=1");
		
		List<WebElement>pages = driver.findElements(By.xpath("//ul[@id=\"pagination\"]/li/a"));
		System.out.println("Total no of pages: " + pages.size());
		
		for(WebElement p : pages) {
			p.click();
			
			List<WebElement>rows = driver.findElements(By.xpath("//table[@id=\"productTable\"]/tbody/tr"));
			System.out.println("Rows on this page: " + rows.size());
			
			List<WebElement>allCB = driver.findElements(By.xpath("//table[@id=\"productTable\"]/tbody/tr/td[4]/input"));
			for(WebElement c : allCB) {
				//System.out.println("Before Clicking: Selected: " + c.isSelected());
				c.click();
				//System.out.println("After Clicking: Selected: " + c.isSelected());
			}
			
			Thread.sleep(1000);
		}
	}

}
