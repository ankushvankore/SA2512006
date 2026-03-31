package com.TestNGDemos;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;

public class D13CreateStudentsList {
	String fPath = "ExcelFiles/StudentsData.xlsx";
	File file;
	FileOutputStream fos;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	
	@Test
	public void createStudentsData() {
		row = sheet.createRow(0);
		cell = row.createCell(0);
		cell.setCellValue("Vrushali");
		
		//row = sheet.createRow(0);
		cell = row.createCell(1);
		cell.setCellValue("Dethe");
		
		sheet.createRow(1).createCell(0).setCellValue("Meghana");
		sheet.getRow(1).createCell(1).setCellValue("Ram");
	}

	@BeforeTest
	public void beforeTest() throws FileNotFoundException {
		file = new File(fPath);
		fos = new FileOutputStream(file);
		wb = new XSSFWorkbook();
		sheet = wb.createSheet();		//Will create sheet with name Sheet0
	}

	@AfterTest
	public void afterTest() throws IOException {
		wb.write(fos);
		wb.close();
		fos.close();
	}

}
