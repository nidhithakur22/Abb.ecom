package com.test.Utility;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.ArrayList;
import org.apache.commons.math3.stat.inference.TestUtils;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;





public class TestUtil {
	
	
	public static String TESTDATA_SHEET_PATH = "C:\\Users\\Asus\\Desktop\\ProductItem.xlsx";
	static XSSFWorkbook book;
	static XSSFSheet  sheet;
	
	

	
	  @DataProvider(name ="data") public static Object[][] getTestData() throws
	  IOException {
	  
	  
	  FileInputStream file = new FileInputStream(TESTDATA_SHEET_PATH); 
	  book = new XSSFWorkbook(file);
	  
	  sheet = book.getSheetAt(0); 
	  Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	  System.out.println(sheet.getFirstRowNum() + "--------" + sheet.getRow(0).getLastCellNum());
/*	  for (int i = 0; i < sheet.getLastRowNum();i++) 
	  { 
		  for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
						
	  data[i][k] = sheet.getRow(i).getCell(k).toString(); 
	  System.out.println(data[i][k]);
	 } */
	  
		  for(int i =0; i<sheet.getLastRowNum(); i++)
			{
				for(int j = 0; j<sheet.getRow(0).getLastCellNum();j++) {
				 data[i][j] = sheet.getRow(i).getCell(j).toString(); 
				 System.out.println(data[i][j]);
				}}
			
			book.close();
			file.close();
			
			 return data; }
	 
	
	
	
}





	
