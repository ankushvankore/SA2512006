package com.StepDefinition;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class S06JOTRegistration {
	WebDriver driver;
	
	@Given("Launch JOT Site using {string}")
	public void launch_jot_site_using(String url) {
		driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	    driver.get(url);
	}

	@When("Enter the data as follows")
	public void enter_the_data_as_follows(io.cucumber.datatable.DataTable dataTable) {
		System.out.println(dataTable);
		
		List<String>data = dataTable.asList();
		System.out.println(data);
		
		//driver.switchTo().frame(driver.findElement(By.id("formPreviewArea")));
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"formPreviewArea\"]")));
		
		driver.findElement(By.id("first_9")).sendKeys(data.get(0));
		driver.findElement(By.id("last_9")).sendKeys(data.get(1));
		driver.findElement(By.id("input_10")).sendKeys(data.get(2));
		driver.findElement(By.id("input_3")).sendKeys(data.get(3));
	}
}
