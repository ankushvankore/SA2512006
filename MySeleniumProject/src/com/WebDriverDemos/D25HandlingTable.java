package com.WebDriverDemos;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D25HandlingTable {

	/*
	 * 1. Display all headers
	 * 2. Display total no of rows
	 * 3. Display any row randomly
	 */
	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.guru99.com/test/web-table-element.php");
		
		//List<WebElement>allHeaders = driver.findElements(By.tagName("th"));
		List<WebElement>allHeaders = driver.findElements(By.xpath("//table[@class=\"dataTable\"]/thead/tr/th"));
		for(WebElement h : allHeaders)
			System.out.println(h.getText());
		
		List<WebElement>rows = driver.findElements(By.xpath("//table[@class=\"dataTable\"]/tbody/tr"));
		System.out.println("Total no of Rows: " + rows.size());
		
		Random rnd = new Random();
		int i = rnd.nextInt(rows.size());
		
		System.out.println(rows.get(i).getText());
		System.out.println(driver.findElement(By.xpath("//table[@class=\"dataTable\"]/tbody/tr[" + (i+1) + "]")).getText());
		
		driver.close();
	}

}
