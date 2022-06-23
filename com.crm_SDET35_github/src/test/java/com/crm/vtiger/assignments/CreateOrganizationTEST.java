package com.crm.vtiger.assignments;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationTEST 
{
public static void main(String[] args) throws IOException 
{
	FileInputStream fis=new FileInputStream("src/main/resources/prop.properties");
	Properties prop = new Properties();
	prop.load(fis);
	
	WebDriver driver=null;
	String URL = prop.getProperty("url");
	String USERNAME = prop.getProperty("username");
	String PASSWORD = prop.getProperty("password");
	String BROWSER = prop.getProperty("browser");
	
	FileInputStream fis1= new FileInputStream("src/main/resources/organisation_ass.xlsx");
	Workbook book=WorkbookFactory.create(fis1);
	Sheet sheet = book.getSheet("sheet1");
	Row row = sheet.getRow(0);
	Cell cell = row.getCell(0);
	String organization_name = cell.getStringCellValue();
	
	
	
	
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	else if(BROWSER.equalsIgnoreCase("firefox"))
			{
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
			}
	else
	{
		driver=new ChromeDriver();
		
			}
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get(URL);
	driver.findElement(By.xpath("//input[@type='text']")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.xpath("(//a[.='Organizations'])[1]")).click();
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("TESTYANTRA_RMG_1");
	WebElement indstry_dd = driver.findElement(By.xpath("//select[@name='industry']"));
	Select sel=new Select(indstry_dd);
	sel.selectByValue("Engineering");
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	WebElement text = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
	String expect_orgnisation_name = text.getText();
	if(expect_orgnisation_name.contains(organization_name))
	{
		System.out.println("oragisation name is created");
	}
	else
	{
		System.out.println("organisation name is not created");
	}
	
	
}
}
