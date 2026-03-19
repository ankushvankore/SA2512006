package com.WebDriverDemos;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D38HandlingDynamicWebTable {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://testautomationpractice.blogspot.com/?m=1");
		
		int rowIndex = 1;
		List<WebElement>browserNames = driver.findElements(By.xpath("//table[@id=\"taskTable\"]/tbody/tr/td[1]"));
		for(WebElement b : browserNames) {
			if(b.getText().equals("Chrome")) {
				break;
			}
			rowIndex++;
		}
		System.out.println("Row Index: " + rowIndex);
		
		int colIndex = 1;
		List<WebElement>columns = driver.findElements(By.xpath("//table[@id=\"taskTable\"]/thead/tr/th"));
		
		for(WebElement c : columns) {
			if(c.getText().contains("CPU")) {
				break;
			}
			colIndex++;
		}
		System.out.println("Column Index: " + colIndex);
		
		String expValue = driver.findElement(By.className("chrome-cpu")).getText();
		String actValue = driver.findElement(By.xpath("//table[@id=\"taskTable\"]/tbody/tr["+rowIndex+"]/td["+colIndex+"]")).getText();
		
		System.out.println("Expected Value: " + expValue);
		System.out.println("Actual Value  : " + actValue);
		
		//System.out.println(actValue);
		if(expValue.equals(actValue))
			System.out.println("Both values are matching!!! Test case pass");
		else
			System.out.println("Both values are not matching!!! Test case fail");
	}

}
