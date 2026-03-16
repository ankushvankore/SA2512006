package com.WebDriverDemos;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class D22Synchronization_ExplicitWait {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        driver.get("https://omayo.blogspot.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        
        WebElement checkBox = driver.findElement(By.id("dte"));
        
        System.out.println("---------- Before Clicking -----------");
        System.out.println("Selected: " + checkBox.isSelected());
        System.out.println("Enabled : " + checkBox.isEnabled());
        
        driver.findElement(By.xpath("//*[@id=\"HTML47\"]/div[1]/button")).click();
        //Thread.sleep(10000);
        //wait.until(ExpectedConditions.elementToBeClickable(checkBox));
        //This will wait till the check box get enabled (maximum for 20 seconds)
        //checkBox.click();
        
        //wait.until(ExpectedConditions.elementToBeClickable(checkBox)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("dte"))).click();
        
        System.out.println("---------- After Clicking -----------");
        System.out.println("Selected: " + checkBox.isSelected());
        System.out.println("Enabled : " + checkBox.isEnabled());
	}

}
