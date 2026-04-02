package com.StepDefinition;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class S02GoogleSearch {
	WebDriver driver;
	
	@Given("Open Google")
	public void open_google() {
		driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	    driver.get("https://www.google.com");
	}
	
	@When("Enter a keyword to search")
	public void enter_a_keyword_to_search() {
	    driver.findElement(By.name("q")).sendKeys("BDD Via Cucumber");
	}

	@When("Hit Enter key")
	public void hit_enter_key() {
	    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	}

	@Then("A valid search result should display")
	public void a_valid_search_result_should_display() {
	    Assert.assertTrue(driver.getCurrentUrl().contains("Cucumber"));
	}
}
