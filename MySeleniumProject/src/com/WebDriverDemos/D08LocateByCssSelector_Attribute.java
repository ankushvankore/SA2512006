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
		
		WebElement firstName = driver.findElement(By.cssSelector("input[ng-model='FirstName']"));
		firstName.sendKeys("Riya");
		WebElement lastName = driver.findElement(By.cssSelector("input[type='text'][placeholder='Last Name']"));
		lastName.sendKeys("Maheshwari");
	}

}
