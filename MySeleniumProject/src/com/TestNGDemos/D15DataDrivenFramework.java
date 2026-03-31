package com.TestNGDemos;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

/*
 * 1. Read user name & password from Excel file
 * 2. Pass user name & password to @Test case
 * 3. Update Result & Message column from Excel file
 */

public class D15DataDrivenFramework {
	String fPath = "ExcelFiles/LoginData.xlsx";
	File file;
	FileInputStream fis;
	FileOutputStream fos;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	int index = 1;
	String message;

	WebDriver driver;
	JavascriptExecutor js;

	@Test(dataProvider = "getLoginData")
	public void login(String un, String ps) {
		driver.findElement(By.id("username")).sendKeys(un);
		driver.findElement(By.id("password")).sendKeys(ps);
		driver.findElement(By.id("submit-login")).submit();
	}

	@AfterMethod
	public void logout() {
		row = sheet.getRow(index);
		cell = row.getCell(2);

		if(driver.getCurrentUrl().contains("secure")) {
			System.out.println("Test case pass");
			message = driver.findElement(By.id("username")).getText();

			js.executeScript("window.scrollBy(0,300)", "");
			js.executeScript("arguments[0].click()",driver.findElement(By.linkText("Logout")));

			cell.setCellValue("Pass");
		}
		else {
			message = driver.findElement(By.id("flash")).getText();
			System.out.println("Test case fail");
			cell.setCellValue("Fail");
		}
		sheet.getRow(index).getCell(3).setCellValue(message);
		
		index++;
	}

	@DataProvider
	public Object[][] getLoginData() {
		int rows = sheet.getPhysicalNumberOfRows();
		String[][] loginData = new String[rows-1][2];

		for(int i = 0; i < rows-1; i++) {
			row = sheet.getRow(i+1);
			for(int j = 0; j < 2; j++) {
				cell = row.getCell(j);
				loginData[i][j] = cell.getStringCellValue();
			}
		}
		return loginData;
	}

	@BeforeTest
	public void beforeTest() throws IOException {
		file = new File(fPath);
		fis = new FileInputStream(file);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheetAt(0);
		fos = new FileOutputStream(file);

		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://practice.expandtesting.com/login");

		js = (JavascriptExecutor) driver;
	}

	@AfterTest
	public void afterTest() throws IOException {
		wb.write(fos);
		wb.close();
		fis.close();

		driver.close();
	}

}
