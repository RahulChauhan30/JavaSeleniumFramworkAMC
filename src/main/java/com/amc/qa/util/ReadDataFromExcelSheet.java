package com.amc.qa.util;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.amc.qa.base.TestBase;

public class ReadDataFromExcelSheet extends TestBase{

	public static String  filePath = "C:\\Users\\Rahul Chauhan\\eclipse-workspace\\AMCTest\\src\\main\\java\\com\\amc\\qa\\data\\ContactUs.xlsx";
	
//	Workbook workbook;
//	Sheet sheet;
	
	public  Object[][] getExcelDataAsString(String filePath,String sheetName) throws IOException
	{
		FileInputStream fis = new FileInputStream(filePath);
		
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		
		int rowCount = sheet.getPhysicalNumberOfRows();
		int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		
		Object[][] data = new Object[rowCount-1][colCount];//Skip Header row
		
		for(int i=1; i<rowCount; i++)
		{
			Row row = sheet.getRow(i);
			for(int j=0; j<colCount; j++)
			{
				Cell cell = row.getCell(j);
				if(cell== null)
				{
					data[i-1][j] = "";
				}
				else
				{
					//convert everythig to string
					cell.setCellType(CellType.STRING);
					data[i-1][j] = cell.getStringCellValue();
				}
			}
		}
		
		workbook.close();
		fis.close();
		return data;
		
	}
}
