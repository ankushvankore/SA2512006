package com.WebDriverDemos;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class D18HandlingDropdownList {

	/*
	 * 1. Display the selected country from the list
	 * 2. Display total no of countries from the list
	 * 3. Select Canada from the list
	 * 4. Display the selected country
	 */
	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
		
		WebElement drpList = driver.findElement(By.id("country"));
		Select countries = new Select(drpList);
		//The operations on the drop down list can be performed only via this object of Select class
		
		System.out.println("Selected Country: " + countries.getFirstSelectedOption().getText());
		
		List<WebElement>allCountries = countries.getOptions();
		System.out.println("Total Countries: " + allCountries.size());
		
		/*int i = 0;
		for(WebElement c : allCountries) {
			System.out.println(i + ". " + c.getText());
			i++;
		}*/
		
		//countries.selectByVisibleText("Canada");
		//countries.selectByContainsVisibleText("Can");
		//countries.selectByValue("37");
		countries.selectByIndex(35);
		System.out.println("Selected Country: " + countries.getFirstSelectedOption().getText());
	}

}
