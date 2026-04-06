package com.StepDefinition;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class S07DataDrivenTesting_OHRM {
	WebDriver driver;
	
	@Given("Launch Orange HRM application")
	public void launch_orange_hrm_application() {
		driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@When("Enter user name as {string}")
	public void enter_user_name_as(String un) {
	    driver.findElement(By.name("username")).sendKeys(un);
	}

	@When("Enter password as {string}")
	public void enter_password_as(String ps) {
		driver.findElement(By.name("password")).sendKeys(ps);
	}

	@When("User clicks on login button")
	public void user_clicks_on_login_button() {
	    driver.findElement(By.xpath("//button[@type='submit']")).sendKeys(Keys.ENTER);
	}

	@Then("Dashboard page should display")
	public void dashboard_page_should_display() throws InterruptedException {
		Thread.sleep(5000);
	    Assert.assertTrue(driver.getCurrentUrl().contains("dash"));
	}

}
