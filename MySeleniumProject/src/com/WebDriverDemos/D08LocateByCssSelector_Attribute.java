package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D08LocateByCssSelector_Attribute {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demo.automationtesting.in/Register.html");
		
		WebElement firstName = driver.findElement(By.cssSelector("input[placeholder='First Name']"));
		firstName.sendKeys("Riya");
	}

}
