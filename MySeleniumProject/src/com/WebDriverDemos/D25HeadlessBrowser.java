package com.WebDriverDemos;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class D25HeadlessBrowser {

	public static void main(String[] args) {
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--headless");
		
		WebDriver driver = new ChromeDriver(op);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.guru99.com/test/web-table-element.php");
		
		//List<WebElement>allHeaders = driver.findElements(By.tagName("th"));
		System.out.println("-------- All Headers ----------");
		List<WebElement>allHeaders = driver.findElements(By.xpath("//table[@class=\"dataTable\"]/thead/tr/th"));
		for(WebElement h : allHeaders)
			System.out.println(h.getText());
		
		driver.close();
	}

}
