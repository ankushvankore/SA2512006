package com.WebDriverDemos;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D27HandlingFileUpload {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://demoqa.com/automation-practice-form");

		JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("window.scrollBy(0, 200)", "");

		driver.findElement(By.id("firstName")).sendKeys("Meghana");
		driver.findElement(By.id("lastName")).sendKeys("Ram");
		driver.findElement(By.id("userEmail")).sendKeys("meghana@gmail.com");
		driver.findElement(By.id("gender-radio-2")).click();
		driver.findElement(By.id("userNumber")).sendKeys("9898989898");

		driver.findElement(By.id("dateOfBirthInput")).sendKeys(Keys.CONTROL + "A");
		driver.findElement(By.id("dateOfBirthInput")).sendKeys("25 May 2000", Keys.ENTER);
		driver.findElement(By.id("subjectsInput")).sendKeys("E");
		driver.findElement(By.xpath("//*[@id=\"react-select-2-option-0\"]")).click();
		
		WebElement hChechBox = driver.findElement(By.id("hobbies-checkbox-1"));
		js.executeScript("arguments[0].click()", hChechBox);
		
		
		driver.findElement(By.id("uploadPicture")).sendKeys("C:\\Users\\Dell\\Downloads\\ChatGPT Image Mar 16, 2026, 07_31_56 PM.png");
		

		// js.executeScript("arguments[0].style.border='3px solid red'",
		// driver.findElement(By.id("uploadPicture")));
	}

}
