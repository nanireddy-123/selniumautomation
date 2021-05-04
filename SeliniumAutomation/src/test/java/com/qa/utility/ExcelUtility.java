package com.qa.utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public static FileInputStream fileloc;
	public static XSSFWorkbook wBook;
	public static XSSFSheet wSheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static  int getRowCount(String xfile, String xsheet) throws IOException
	{
		fileloc = new FileInputStream(xfile);
		wBook  = new XSSFWorkbook(fileloc);
		wSheet = wBook.getSheet(xsheet);
		
		int rowCount = wSheet.getLastRowNum();
		wBook.close();
		fileloc.close();
		
		return rowCount;	
	}
	
	public static int getCellCount(String xfile, String xsheet ,int rowNum) throws IOException
	{
		fileloc = new FileInputStream(xfile);
		wBook  = new XSSFWorkbook(fileloc);
		wSheet = wBook.getSheet(xsheet);
		
		row = wSheet.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		
		wBook.close();
		fileloc.close();
		
		return cellCount;
		
	}
	
	public static String  getCellData(String xfile, String xsheet ,int rowNum, int colnum) throws IOException
	{
		fileloc = new FileInputStream(xfile);
		wBook  = new XSSFWorkbook(fileloc);
		wSheet = wBook.getSheet(xsheet);
		row = wSheet.getRow(rowNum);
		cell = row.getCell(colnum);
		
		DataFormatter formatter = new DataFormatter();
		String cellData = formatter.formatCellValue(cell);
		wBook.close();
		fileloc.close();
		
		return cellData;
		
		
	
	}
}
