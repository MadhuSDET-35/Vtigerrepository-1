package com.crm.vtiger.assignments;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContactWithOrganisation 
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		//fetch data from property file
	FileInputStream fis=new FileInputStream("src/main/resources/prop.properties");
	Properties prop = new Properties();
	prop.load(fis);

	WebDriver driver=null;
	String URL = prop.getProperty("url");
	String USERNAME = prop.getProperty("username");
	String PASSWORD = prop.getProperty("password");
	String BROWSER = prop.getProperty("browser");
	
	//fetch data from excel sheet
	FileInputStream fis1= new FileInputStream("src/main/resources/organisation_ass.xlsx");
	Workbook book=WorkbookFactory.create(fis1);
	Sheet sheet = book.getSheet("sheet1");
	Row row = sheet.getRow(1);
	Cell cell = row.getCell(0);
	String organization_name = cell.getStringCellValue();
	System.out.println(organization_name);
	
	Cell cell1 = row.getCell(1);
	DataFormatter data=new DataFormatter();
	String phone_number = data.formatCellValue(cell1);
	System.out.println(phone_number);
	}
}
	
	/*Cell cell2 = row.getCell(2);
	String firstname = cell2.getStringCellValue();
	System.out.println(firstname);
	
	Cell cell3 = row.getCell(3);
	String lastname = cell3.getStringCellValue();
	System.out.println(lastname);
	
	Cell cell4 = row.getCell(4);
	String expectedname = cell4.getStringCellValue();
	
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
	driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(organization_name);
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
	driver.findElement(By.xpath("//a[.='Contacts']")).click();
	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	WebElement contact = driver.findElement(By.name("salutationtype"));
	Select sel1=new Select(contact);
	sel1.selectByValue("Mr.");
	driver.findElement(By.name("firstname")).sendKeys(firstname);
	driver.findElement(By.name("lastname")).sendKeys(lastname);
	driver.findElement(By.name("mobile")).sendKeys(phone_number);
	driver.findElement(By.xpath("(//img[@language='javascript'])[1]")).click();
	Set<String> ids = driver.getWindowHandles();
	ArrayList<String> windowids=new ArrayList<String>(ids);
	String child_window = windowids.get(1);
	driver.switchTo().window(child_window);
	driver.findElement(By.id("search_txt")).sendKeys("test");
	driver.findElement(By.name("search")).click();
	driver.findElement(By.xpath("//a[.='TEST YANTRA_RMG222']")).click();
	String parentid = windowids.get(0);
	driver.switchTo().window(parentid);
	driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
	WebElement contactdetails = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
	String actualcontactinfo = contactdetails.getText();
	String expectedcontactname = expectedname;
	System.out.println(actualcontactinfo);
	if(actualcontactinfo.contains(expectedcontactname))
	{
		System.out.println("contact and organisation is successfully created");
	}
	else
	{
		System.out.println("contact and organisation is not created");
	}
	
	}
}*/

	
