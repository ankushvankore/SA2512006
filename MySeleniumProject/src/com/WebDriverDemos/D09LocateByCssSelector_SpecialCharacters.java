package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D09LocateByCssSelector_SpecialCharacters {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
		
		WebElement fullName = driver.findElement(By.cssSelector("input[name^='name']"));
		fullName.sendKeys("Anuj Gupta");
		WebElement rediffId = driver.findElement(By.cssSelector("input[id^='login']"));
		rediffId.sendKeys("anujgupta");
		WebElement password = driver.findElement(By.cssSelector("input[placeholder$='password'][name^='pass']"));
		password.sendKeys("anuj@123");
		WebElement confirmPassword = driver.findElement(By.cssSelector("input[placeholder*='type pas']"));
		confirmPassword.sendKeys("anuj@123");
	}

}
