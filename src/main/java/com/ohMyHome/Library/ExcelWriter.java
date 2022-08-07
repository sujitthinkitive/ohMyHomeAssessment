package com.ohMyHome.Library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter {
	
	
	Workbook book;
	FileInputStream finp;
	public void writeExcelData(String excelName, String sheetName, List<ArrayList<Integer>> allTickets) throws InvalidFormatException, IOException
	{
		int rowNumber=0;
		int columnNumber=0;
		Row row;
		File file = new File("Resources"+File.separator+excelName);
	
		if(file.exists())
		{
			file.delete();
		}
		
		//finp = new FileInputStream(file);
		
		//book = new WorkbookFactory().create(finp);
		book = new XSSFWorkbook();
		Sheet sheet;
		
			sheet = book.createSheet(sheetName);
		
		for(ArrayList<Integer> singleTicket:allTickets)
		{
			row = sheet.createRow(rowNumber);
			Object[] tktNumbers = singleTicket.toArray();
			
			for(Object a:tktNumbers)
			{
				Cell cell = row.createCell(columnNumber);
				cell.setCellValue(a.toString());
				columnNumber++;
			}
			rowNumber++;
			columnNumber=0;
		}
		
		FileOutputStream output = new FileOutputStream(file);
		book.write(output);
		output.close();
		
		
	}
	
	
	public void writeExcelData(String excelName, String sheetName, List<ArrayList<Integer>> allTickets, int rowNum) throws InvalidFormatException, IOException
	{
		int rowNumber=rowNum;
		int columnNumber=0;
		Row row;
		File file = null;
		
		try {
			file = new File("Resources"+File.separator+excelName);
			finp = new FileInputStream(file);
			book = new XSSFWorkbook(finp);
		} catch (Exception e) {
			book = new XSSFWorkbook();
		}
	/*
		if(file.exists())
		{
			file.delete();
		}
		*/
		
		
		//book = new WorkbookFactory().create(finp);
		Sheet sheet;
		if(rowNumber==0 && book.getSheet(sheetName)==null)
		{
			sheet = book.createSheet(sheetName);
		}else
		{
			sheet = book.getSheet(sheetName);
		}
		
		for(ArrayList<Integer> singleTicket:allTickets)
		{
			row = sheet.createRow(rowNumber);
			Object[] tktNumbers = singleTicket.toArray();
			
			for(Object a:tktNumbers)
			{
				Cell cell = row.createCell(columnNumber);
				cell.setCellValue(a.toString());
				columnNumber++;
			}
			rowNumber++;
			columnNumber=0;
		}
		
		
		FileOutputStream output = new FileOutputStream(file);
		book.write(output);
		output.close();
		
		
	}

}
