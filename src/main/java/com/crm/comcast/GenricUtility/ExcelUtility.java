package com.crm.comcast.GenricUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author Mamatha
 *
 */

public class ExcelUtility {

	/**
	 * this method will return string value from excel sheet
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws Throwable
	 */
	
	public String getStringCellData(String sheetName, int rowNo, int cellNo) throws Throwable   {
		FileInputStream fis = new FileInputStream(IpathConstant.EXCEL_FILE_PATH);
		Workbook workbook = WorkbookFactory.create(fis);
		return workbook.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
		
	}
	
	/**
	 * this method return numeric value from excel sheet
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws Throwable
	 */
	public double getNumericCellData(String sheetName,int rowNo, int cellNo) throws Throwable {
		
		FileInputStream fis= new FileInputStream(IpathConstant.EXCEL_FILE_PATH);
		Workbook workbook = WorkbookFactory.create(fis);
		return workbook.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getNumericCellValue();
	}
	
	
	/**
	 * this method returns multiple data from excel sheet
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	
	public Object[][] getMultipleData(String sheetName) throws Throwable {
		
		FileInputStream fis = new FileInputStream(IpathConstant.EXCEL_FILE_PATH);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		int lastrow = sheet.getLastRowNum();
		int lastcell= sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object [lastrow][lastcell];
		for(int i=0; i<lastrow;i++)
		{
			for(int j=0;j<lastcell;j++)
			{
				data[i][j]=sheet.getRow(i).getCell(j).toString();
			  
			}
		}
		
		return data;
	}
	
	/**
	 * this method is used to write data into excell sheet
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param value
	 * @throws Throwable
	 */
	
	public void writeDataIntoExcel(String sheetName,int rowNum, int cellNum, String value) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IpathConstant.EXCEL_FILE_PATH);
		Workbook workbook = WorkbookFactory.create(fis);
	    workbook.createSheet(sheetName).createRow(rowNum).createCell(cellNum).setCellValue(value);
		
	    FileOutputStream fos = new FileOutputStream(IpathConstant.EXCEL_FILE_PATH);
	    workbook.write(fos);
	   
	    workbook.close();
	}
}
