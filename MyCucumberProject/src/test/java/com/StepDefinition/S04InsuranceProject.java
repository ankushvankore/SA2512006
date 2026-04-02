package com.StepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class S04InsuranceProject {
	WebDriver driver;
	
	@Given("Open Insurance project")
	public void open_insurance_project() {
		driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	    driver.get("https://sampleapp.tricentis.com/101/index.php");
	}

	@When("Click on Automobile link")
	public void click_on_automobile_link() {
	    driver.findElement(By.linkText("Automobile")).click();
	}

	@When("Select the make as {string}")
	public void select_the_make_as(String make) {
	    new Select(driver.findElement(By.id("make"))).selectByVisibleText(make);
	}

	@When("Enter engine performance as {string}")
	public void enter_engine_performance_as(String ep) {
	    driver.findElement(By.id("engineperformance")).sendKeys(ep);
	}

	@When("Enter date of manufacture as {string}")
	public void enter_date_of_manufacture_as(String dom) {
	    driver.findElement(By.id("dateofmanufacture")).sendKeys(dom);
	}

	@When("Select no of seats as {string}")
	public void select_no_of_seats_as(String seats) {
	    new Select(driver.findElement(By.id("numberofseats"))).selectByVisibleText(seats);
	}

	@When("Select fuel type as {string}")
	public void select_fuel_type_as(String fuel) {
	    new Select(driver.findElement(By.id("fuel"))).selectByContainsVisibleText(fuel);
	}
}
