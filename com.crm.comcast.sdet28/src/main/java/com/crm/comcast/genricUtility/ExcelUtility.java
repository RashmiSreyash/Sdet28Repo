package com.crm.comcast.genricUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility 
{
	/**
	 * This method will return string value from excel sheet
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws Throwable
	 */
	public String getStringCellData(String sheetName, int rowNo , int cellNo) throws Throwable 
	{
		FileInputStream fis = new FileInputStream(IPathConstants.EXCEL_FILEPATH1);
		  Workbook workbook = WorkbookFactory.create(fis);
		  Sheet sheet = workbook.getSheet(sheetName);
		   Row row = sheet.getRow(rowNo);
		   Cell cell = row.getCell(cellNo);
		   return cell.getStringCellValue();
		}
	/**
	 * this method will return numric cell data
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws Throwable
	 */
	public double getNumricCellData(String sheetName, int rowNo, int cellNo) throws Throwable {
		FileInputStream file = new FileInputStream(IPathConstants.EXCEL_FILEPATH1);
		Workbook workbook = WorkbookFactory.create(file);
		return workbook.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getNumericCellValue();
		
		
	}
	
	public Object[][] getMultipleData(String sheetName) throws Throwable
	{
		FileInputStream file = new FileInputStream(IPathConstants.EXCEL_FILEPATH1);
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet=workbook.getSheet(sheetName);
		int rowNo=sheet.getLastRowNum();
		int cellNo=sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[rowNo][cellNo];
		{
			for(int i=0;i<rowNo;i++)
			{
			for(int j=0;j<cellNo;j++)
			{
				data[i][j]=sheet.getRow(i).getCell(j).toString();
			}
		}
		return data;
	}
	}
	
	public void writeDataIntoExcel(String sheetName,int rowNo, int cellNo, String value) throws Throwable
	{
		FileInputStream readfile = new FileInputStream(IPathConstants.EXCEL_FILEPATH1);
		Workbook workbook = WorkbookFactory.create(readfile);
		workbook.createSheet(sheetName).createRow(rowNo).createCell(cellNo).setCellValue(value);
		
		
		FileOutputStream writeFile = new FileOutputStream(IPathConstants.EXCEL_FILEPATH1);
		workbook.write(writeFile);
		workbook.close();
	}

}
