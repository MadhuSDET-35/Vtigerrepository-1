package com.crm.vtiger.assignments;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverManager;
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

import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContacts 
{
	public static void main(String[] args) throws IOException 
	{
		FileInputStream fis=new FileInputStream("src/main/resources/prop.properties");
		Properties prop = new Properties();
		prop.load(fis);
		WebDriver driver=null;
		
		String USERNAME = prop.getProperty("username");
		String PASSWORD = prop.getProperty("password");
		String URL = prop.getProperty("url");
		String BROWSER = prop.getProperty("browser");
		
		
		String exp_contactname = "N R MADHUSUDAN";
		
		/*FileInputStream fis1= new FileInputStream("src/main/resources/organisation_ass.xlsx");
		Workbook book=WorkbookFactory.create(fis1);
		Sheet sheet = book.getSheet("sheet1");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		String organization_name = cell.getStringCellValue();*/
		
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
		driver.findElement(By.xpath("//a[.='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		WebElement contact = driver.findElement(By.name("salutationtype"));
		Select sel=new Select(contact);
		sel.selectByValue("Mr.");
		driver.findElement(By.name("firstname")).sendKeys("MADHUSUDAN");
		driver.findElement(By.name("lastname")).sendKeys("N R");
		driver.findElement(By.name("mobile")).sendKeys("8310414456");
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		 WebElement text =driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		 String actual_contactname = text.getText();
		 System.out.println(actual_contactname);
		 if(actual_contactname.contains(exp_contactname))
		 {
			 System.out.println("contact saved");
		 }
		 else
		 {
			 System.out.println("contact is not saved");
		 }
		 
		

		 
		
		
	}

}
