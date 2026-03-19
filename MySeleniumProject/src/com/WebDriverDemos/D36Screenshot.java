package com.WebDriverDemos;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class D36Screenshot {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://jqueryui.com/droppable/");

		Actions act = new Actions(driver);

		driver.findElement(By.linkText("Droppable")).click();

		// driver.switchTo().frame(0);
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));

		act.dragAndDrop(source, target).perform();

		// File class --> the object of this class is capable to hold any type of file
		// from your system.
		TakesScreenshot ss = (TakesScreenshot) driver;
		File screenShot = ss.getScreenshotAs(OutputType.FILE);

		FileHandler.copy(screenShot, new File("Screenshots\\JQueryScreenshot.jpeg"));
		System.out.println("Screenshot captured!!!");

		driver.close();
	}

}
