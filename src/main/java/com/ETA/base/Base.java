package com.ETA.base;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.Rows;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	
	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream fis;
	
	public static WebDriver initializer() throws IOException
	{
		 prop= new Properties();
		fis= new FileInputStream("D:\\Selenium\\ETAProject\\src\\main\\java\\com\\ETA\\config\\config.properties");
		prop.load(fis);
		
		
		String browserName=prop.getProperty("browser");
		if (browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
			driver=new ChromeDriver();
			
			
		}
		else if(browserName.equals("FF"))
		{
			System.setProperty("webdriver.firefox.marionette","D:\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browserName.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "D:\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
		
		
		return driver;
		
		
		
	}
	
	public void getScreenshot(String result) throws IOException
	{
		File Src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Src,new File("D:\\Selenium\\ETAProject\\Screenshot\\"+result+"\\screenshot.png"));
		
	}
	
	
	public List<String> getData(String testcaseName) throws IOException
	{
		//prop= new Properties();
		fis= new FileInputStream("D:\\Selenium\\ETAProject\\src\\main\\java\\com\\ETA\\TestData\\Test.xls");
	
		//Identify Testcases coloum by scanning the entire 1st row
		//once coloumn is identified then scan entire testcase coloum to identify purcjhase testcase row
		//after you grab purchase testcase row = pull all the data of that row and feed into test

		
		//fileInputStream argument
		List<String> a=new ArrayList<String>();

		HSSFWorkbook workbook=new HSSFWorkbook(fis);

		int sheets=workbook.getNumberOfSheets();
		for(int i=0;i<sheets;i++)
		{
		if(workbook.getSheetName(i).equalsIgnoreCase(prop.getProperty("sheetName")))
		{
		HSSFSheet sheet=workbook.getSheetAt(i);
		//Identify Testcases coloum by scanning the entire 1st row

		Iterator<Row>  rows= sheet.iterator();// sheet is collection of rows
		Row firstrow= rows.next();
		Iterator<Cell> ce=firstrow.cellIterator();//row is collection of cells
		int k=0;
		int coloumn = 0;
		while(ce.hasNext())
		{
		Cell value=ce.next();

		if(value.getStringCellValue().equalsIgnoreCase("TestCases"))
		{
		coloumn=k;

		}

		k++;
		}
		System.out.println(coloumn);

		////once coloumn is identified then scan entire testcase coloum to identify purcjhase testcase row
		while(rows.hasNext())
		{

		Row r=rows.next();

		if(r.getCell(coloumn).getStringCellValue().equalsIgnoreCase(prop.getProperty("testCaseName")))
		{

		////after you grab purchase testcase row = pull all the data of that row and feed into test

		Iterator<Cell>  cv=r.cellIterator();
		while(cv.hasNext())
		{
		Cell c= cv.next();
		if(c.getCellTypeEnum()==CellType.STRING)
		{

		a.add(c.getStringCellValue());
		}
		else{

		a.add(NumberToTextConverter.toText(c.getNumericCellValue()));

		}
		}
		}


		}









		}
		}
		return a;
		
	
	}
	
	
}
