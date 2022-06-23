package com.crm.vtiger.products.assignments;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoToProductCreatingPageFillTheAllfieldsAndCancelTEST 
{
public static void main(String[] args) throws IOException 
{
	FileInputStream fis=new FileInputStream("src/main/resources/prop.properties");
	Properties prop = new Properties();
	prop.load(fis);
	String URL = prop.getProperty("url");
	String USERNAME = prop.getProperty("username");
	System.out.println(USERNAME);
	String PASSWORD = prop.getProperty("password");
	String BROWSER = prop.getProperty("browser");
	System.out.println(BROWSER);
	
	//fetching datas from excel
			FileInputStream fis1=new FileInputStream("src/main/resources/PRODUCTS_TEST_DATAS.xlsx");
			Workbook book=WorkbookFactory.create(fis1);
			Sheet sht = book.getSheet("sheet1");
			Row row = sht.getRow(1);
			Cell cell = row.getCell(1);
			 String PRODUCTNAME = cell.getStringCellValue();
			 System.out.println(PRODUCTNAME);
			 
			 Cell cell1 = row.getCell(2);
			 DataFormatter data=new DataFormatter();
			 String PARTNO= data.formatCellValue(cell1);
			 
			 Cell cell2 = row.getCell(3);
			 String VENDERPARTNO = data.formatCellValue(cell2);
			 
			 Cell cell3 = row.getCell(4);
			 String WEBSITE = cell3.getStringCellValue();
			 
			 Cell cell4 = row.getCell(5);
			 String QUANTITYSTK = data.formatCellValue(cell4);
	
	WebDriver driver=null;
	
	if(BROWSER.equalsIgnoreCase("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}
	else if(BROWSER.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get(URL);
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.xpath("//a[.='Products']")).click();
	driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
	driver.findElement(By.name("productname")).sendKeys(PRODUCTNAME);
	driver.findElement(By.id("productcode")).sendKeys(PARTNO);
	driver.findElement(By.id("vendor_part_no")).sendKeys(VENDERPARTNO);
	driver.findElement(By.name("website")).sendKeys(WEBSITE);
	driver.findElement(By.id("qtyinstock")).sendKeys(QUANTITYSTK);
	driver.findElement(By.xpath("//input[@class='crmbutton small cancel']")).click();
}
}
