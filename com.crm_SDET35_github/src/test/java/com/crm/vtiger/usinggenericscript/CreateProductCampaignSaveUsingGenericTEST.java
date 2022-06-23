package com.crm.vtiger.usinggenericscript;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import generic_utilities.ExcelUtilities;
import generic_utilities.FileUtilities;
import generic_utilities.JavaUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProductCampaignSaveUsingGenericTEST 
{
public static void main(String[] args) throws IOException 
{
	
	WebDriver driver =null;
	ExcelUtilities excelutil = new ExcelUtilities();
	FileUtilities fileutil = new FileUtilities();
	JavaUtility javautil = new JavaUtility();
	
	//fetching properties from propertyfile
	
	String URL = fileutil.getPropertyKeyValue("url");
	String USERNAME = fileutil.getPropertyKeyValue("username");
	String PASSWORD = fileutil.getPropertyKeyValue("password");
	String BROWSER = fileutil.getPropertyKeyValue("browser");
	
	//Fetching properties from excel file
	
	//Fetching product name
	String PRODUCTNAME = excelutil.ReadExceldataValue("sheet2", 1, 2);
	
	//Fetching part no from excel
	String PARTNO = excelutil.ReadExceldataValue("sheet2", 1, 3);
	
	//Fetching serial no
	String SERIALNO = excelutil.ReadExceldataValue("sheet2", 1, 4);
	
	//Fetching random no
	int RANDOMNO = javautil.getRandomNumber();
	
	//Fetching campaign name
	String CAMPAIGN_NAME = excelutil.ReadExceldataValue("sheet2", 1, 5);
	
	
	if(BROWSER.equalsIgnoreCase("firefox")) 
	{
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}
	else if(BROWSER.equals("chrome"))
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
	driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
	driver.findElement(By.name("productname")).sendKeys(PRODUCTNAME);
	driver.findElement(By.name("productcode")).sendKeys(PARTNO+RANDOMNO);
	driver.findElement(By.name("serial_no")).sendKeys(SERIALNO+RANDOMNO);
	driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
	WebElement producttext = driver.findElement(By.xpath("//span[@class='lvtHeaderText']"));
	String productinfo = producttext.getText();
	if(productinfo.contains(PRODUCTNAME)) 
	{
		System.out.println("product added successfully");
	}
	else
	{
		System.out.println("product not added");
	}
	
WebElement moreelement = driver.findElement(By.xpath("//a[.='More']"));
Actions act=new Actions(driver);
act.moveToElement(moreelement).perform();
driver.findElement(By.xpath("//a[.='Campaigns']")).click();
driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
driver.findElement(By.name("campaignname")).sendKeys(CAMPAIGN_NAME);
driver.findElement(By.xpath("//img[@title='Select']")).click();
Set<String> allids = driver.getWindowHandles();
ArrayList<String> idsinindex=new ArrayList<String>(allids) ;
String childwindow = idsinindex.get(1);
String parentwindow = idsinindex.get(0);
driver.switchTo().window(childwindow);



}
	
	
}
