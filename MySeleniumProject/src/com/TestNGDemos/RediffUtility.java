package com.TestNGDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RediffUtility {
	
	/*
	 * Other ways to use driver object form client class are
	 * 1. Mark driver object of client class as public static and use 
	 *    in this utility class as clientclass.driver
	 * 2. Inherit this utility class inside client class 
	 * 	  mark driver object as protected static 
	 */
	
	/*
	 * Page Factory
	 * It is collection of WebElements those can be reused in utility class
	 * It acts as Object Repository
	 * Page factory is sub set of Page Object Model
	 */
	
	WebDriver driver;
	
	@FindBy(xpath = "//input[@placeholder='Enter your full name']") private WebElement fullName;
	@FindBy(className = "month")WebElement monthDD;
	
	public RediffUtility(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterFullName(String fn) {
		//driver.findElement(By.xpath("//input[@placeholder='Enter your full name']")).sendKeys(fn);
		fullName.sendKeys(fn);
	}
	
	public void enterRediffId(String rid) {
		driver.findElement(By.xpath("//input[contains(@id, 'login')]")).sendKeys(rid);
	}
	
	public void enterPassword(String ps) {
		driver.findElement(By.xpath("//input[@id='newpasswd']")).sendKeys(ps);
		driver.findElement(By.xpath("//input[@id='newpasswd1']")).sendKeys(ps);
	}

	public void setBirthDate(String day, String month, String year) {
		Select dayDD = new Select(driver.findElement(By.className("day")));
		dayDD.selectByVisibleText(day);
		//new Select(driver.findElement(By.className("month"))).selectByVisibleText(month);
		new Select(monthDD).selectByVisibleText(month);
		new Select(driver.findElement(By.className("year"))).selectByVisibleText(year);
	}
	
	public String checkAvailablity() throws InterruptedException {
		driver.findElement(By.className("btn_checkavail")).click();
		Thread.sleep(5000);
		return driver.findElement(By.id("check_availability")).getText();
	}
}
