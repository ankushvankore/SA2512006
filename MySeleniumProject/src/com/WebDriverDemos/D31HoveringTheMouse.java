package com.WebDriverDemos;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class D31HoveringTheMouse {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://istqb.in/");
		
		Actions act = new Actions(driver);
		
		WebElement foundationMenu = driver.findElement(By.xpath("(//span[text()='FOUNDATION'])[1]"));
		act.moveToElement(foundationMenu).perform();
		
		List<WebElement>subMenus = driver.findElements(By.xpath("//*[@id=\"sp-menu\"]/div/nav/ul/li[3]/div/div/div/div/ul/li/a"));
		for(WebElement s : subMenus)
			System.out.println(s.getText());
		
		Thread.sleep(2000);
		driver.close();
	}

}
