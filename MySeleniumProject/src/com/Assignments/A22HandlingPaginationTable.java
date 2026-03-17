package com.Assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class A22HandlingPaginationTable {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/?m=1");
		
		//Handling pagination table
		
		//Find total no of pages
		List<WebElement>pages = driver.findElements(By.xpath("//div[@class=\"table-container\"]/ul/li/a"));
		int noOfPages = pages.size();
		
		System.out.println("Total no of pages: " + noOfPages);
		
		int totalRows = 0;
		
		for(WebElement p : pages) {
			p.click();
			//Read rows form each page
			List<WebElement>rows = driver.findElements(By.xpath("//table[@id=\"productTable\"]/tbody/tr"));
			System.out.println("Rows on this page: " + rows.size());
			//totalRows += rows.size();
			totalRows = totalRows + rows.size();
			Thread.sleep(1000);
			//Read and click the check boxes on each page
			List<WebElement>checkBoxes = driver.findElements(By.xpath("//table[@id=\"productTable\"]/tbody/tr/td[4]/input"));
			for(WebElement c : checkBoxes) {
				Thread.sleep(1000);
				c.click();
			}
		}
		
		System.out.println("Total Rows: " + totalRows);
		
		Thread.sleep(2000);
		driver.close();
	}

}
