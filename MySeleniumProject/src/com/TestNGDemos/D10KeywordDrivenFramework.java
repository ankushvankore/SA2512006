package com.TestNGDemos;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class D10KeywordDrivenFramework {
	File file;
	FileInputStream fis;
	Properties prop;
	
	WebDriver driver;
	@Test
	public void automobileTest() {
		driver.findElement(By.linkText(prop.getProperty("autoLinkText"))).click();
		Select makeDD = new Select(driver.findElement(By.id(prop.getProperty("makeDDId"))));
		makeDD.selectByIndex(3);
		driver.findElement(By.name(prop.getProperty("epName"))).sendKeys("1000");
		driver.findElement(By.className(prop.getProperty("domClass"))).sendKeys("03/04/2026");
		Select seats = new Select(driver.findElement(By.xpath(prop.getProperty("seatsXPath"))));
		seats.selectByVisibleText("2");
	}

	@BeforeTest
	public void beforeTest() throws IOException {
		file = new File("src/com/TestNGDemos/MyLocators.properties");
		fis = new FileInputStream(file);
		prop = new Properties();
		prop.load(fis);
		//Will load all the properties / keys in this object
		
		driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(prop.getProperty("url"));
        //prop.getProperty() will fetch the value of specific property
	}

	@AfterTest
	public void afterTest() {
	}

}
