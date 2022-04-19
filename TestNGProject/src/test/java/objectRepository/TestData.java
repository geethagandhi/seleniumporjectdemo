package objectRepository;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class TestData {
	
	public static String readDataExcel(int rownum, int colnum) throws IOException {
		
		//Reading data from Excel
		String data = null;
		File file = new File("C:\\Users\\Geetha\\eclipse-workspace\\Apache POI\\DataFolder\\TestData1.xlsx");
		FileInputStream fis = new FileInputStream(file);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		XSSFRow row = sheet.getRow(rownum);
		XSSFCell cell = sheet.getRow(rownum).getCell(colnum);
		data = cell.getStringCellValue();
		return data;
		
		
		
		
	}
	/*
	public static String excelDataRead(int rownum, int cellnum) throws IOException
	{
		
		String data = null;
		File file1 = new File(".\\DataFolder\\StudentRegistrationFormTestData2.xlsx");
		FileInputStream inputstream = new FileInputStream(file1);
		XSSFWorkbook excel = new XSSFWorkbook(inputstream);
		XSSFSheet sheet = excel.getSheet("Sheet1");
		XSSFRow row = sheet.getRow(rownum);
		XSSFCell cell = sheet.getRow(rownum).getCell(cellnum);
		data = cell.getStringCellValue();
		return data;
		
	}*/
	




}
