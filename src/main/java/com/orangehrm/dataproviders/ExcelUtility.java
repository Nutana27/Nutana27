package com.orangehrm.dataproviders;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.*;

public class ExcelUtility {

	static XSSFWorkbook wb;
	public static Object[][] getDataFromSheet(String sheetName){
		Object arr[][]=null;
		
		try {
			wb=new XSSFWorkbook(new FileInputStream(new File(System.getProperty("user.dir")+ "/TestData/OrangeHRM.xlsx")));
			
			int row=wb.getSheet(sheetName).getPhysicalNumberOfRows();
			
			int column =wb.getSheet(sheetName).getRow(0).getPhysicalNumberOfCells();
			
			arr=new Object[row-1][column];
			
			for(int i=1;i<row;i++) {
				for(int j=0;j<column;j++) {
					arr[i-1][j]=getData(sheetName, i, j);
				}
			}
		}catch(FileNotFoundException e) {
			
		}catch(IOException e) {
			
		}
		return arr;
		
	}
	
	public int getRows(String sheetName) {
		return wb.getSheet(sheetName).getPhysicalNumberOfRows();
	}
	
	public int getColumns(String sheetName) {
		return wb.getSheet(sheetName).getRow(0).getPhysicalNumberOfCells();
	}
	
	public static String getData(String sheetName, int row, int column) {
		XSSFCell cell=wb.getSheet(sheetName).getRow(row).getCell(column);
		
		String data ="";
		if(cell.getCellType()==CellType.STRING) {
			data=cell.getStringCellValue();
		}else if(cell.getCellType()==CellType.NUMERIC) {
			data= String.valueOf(cell.getNumericCellValue());
		}
		else if(cell.getCellType()==CellType.BLANK){
			data="";
		}
		return data;
	}
}
