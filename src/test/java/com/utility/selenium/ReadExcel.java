package com.utility.selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class ReadExcel {

	WebDriver driver = null;

	public static Object[][] readExcel(String file, String sheetName) {

		File fi = new File(file);
		FileInputStream fis = null;
		XSSFWorkbook wb = null;

		try {

			fis = new FileInputStream(fi);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		try {

			wb = new XSSFWorkbook(fis);

		} catch (IOException e) {

			e.printStackTrace();
		}

		XSSFSheet sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getPhysicalNumberOfRows();
		int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

		Object[][] data = new Object[rowCount - 1][colCount];

		for (int rowNum = 1; rowNum < rowCount; rowNum++) {

			XSSFRow row = sheet.getRow(rowNum);

			for (int colNum = 0; colNum < colCount; colNum++) {

				data[rowNum - 1][colNum] = row.getCell(colNum).getStringCellValue();

			}
		}

		try {
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return data;

	}

}
