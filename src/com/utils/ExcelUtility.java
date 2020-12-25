package com.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	// this class is responsible to read excel files and return 2D array
	
	public static Workbook book;
	public static Sheet sheet;
	
	public static void openExcel(String filePath) {
		 
		try{
			FileInputStream fileIS=new FileInputStream(filePath);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void loadSheet(String sheetName) {
		sheet=book.getSheet(sheetName);
		}
	
	public static int rowCount() {
		return sheet.getPhysicalNumberOfRows();
	}
	
	public static int colsCount(int row) {
		return sheet.getRow(row).getLastCellNum();
	}

	public static String cellData(int rowIndex, int colIndex) { // this method will return the date in one cell
		return sheet.getRow(rowIndex).getCell(colIndex).toString();
	}
	
	public static Object [][] excelIntoArray(String filePath, String sheetName){
		openExcel(filePath);
		loadSheet(sheetName);
		
		int rows=rowCount();
		int cols=colsCount(0);
		Object [][]data=new Object[rows-1][cols];
		
			//	we use 1 as we skip header
		for (int i=1; i<rows; i++) {// iterating rows
			
			for (int j=0; j<cols; j++) {// iterating colums
				data [i-1][j] =cellData(i,j);
				
				
			}
		}
		
		return data;
	}
}
