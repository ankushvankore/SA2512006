package com.MyTests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class D07HandlingShadowRoot {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://testautomationpractice.blogspot.com/?m=1");
		
		/*
		 * Handling #shadow-root control
		 * 1. Take a reference of parent tag of #shadow-root control (read that control)
		 *    and call getShodowRoot() and store the output in SearchContext
		 * 2. Read / find the control using SearchContext object
		 * 3. Note that to read the controls from #shadow-root you can use only cssSelector locator
		 */
		
		SearchContext ss = driver.findElement(By.id("shadow_host")).getShadowRoot();
		ss.findElement(By.cssSelector("input[type='text']")).sendKeys("Navya");
	}

}
