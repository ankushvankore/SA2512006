package com.WebDriverDemos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class D02ReadTitle {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.selenium.dev/downloads/");
		
		String title = driver.getTitle();
		System.out.println("Title: " + title);
		
		//if(title.equals("Downloads | Selenium"))
		if(title.contains("Downloads"))
			System.out.println("Title verified... Test case pass!!!");
		else
			System.out.println("Invalid title... Test case fail!!!");
		
		driver.close();
	}

}
