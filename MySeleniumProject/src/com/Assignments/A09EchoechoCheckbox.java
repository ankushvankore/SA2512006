package com.Assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class A09EchoechoCheckbox {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://echoecho.com/htmlforms09.htm");

		//List<WebElement>products = driver.findElements(By.cssSelector("input[name^='option']"));
		//List<WebElement>products = driver.findElements(By.xpath("(//td[@class=\"table5\"])[2]/input"));
		List<WebElement>products = driver.findElements(By.xpath("/html/body/div[2]/table[9]/tbody/tr/td[4]/table/tbody/tr/td/div/span/form/table[3]/tbody/tr/td/table/tbody/tr/td/input"));

		for(WebElement cb : products) {
			System.out.println("-------------- Before --------------");
			System.out.println("Product: " + cb.getAttribute("value"));
			System.out.println("Selected: " + cb.isSelected());
			System.out.println("Enabled : " + cb.isEnabled());
			System.out.println("Visible : " + cb.isDisplayed());

			if(!cb.isSelected() && cb.isEnabled())
				cb.click();

			System.out.println("-------------- After --------------");
			System.out.println("Product: " + cb.getAttribute("value"));
			System.out.println("Selected: " + cb.isSelected());
			System.out.println("Enabled : " + cb.isEnabled());
			System.out.println("Visible : " + cb.isDisplayed());
		}		
	}

}
