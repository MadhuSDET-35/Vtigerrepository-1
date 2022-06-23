package com.crm.vtiger.usinggenericscript;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import generic_utilities.ExcelUtilities;
import generic_utilities.FileUtilities;
import generic_utilities.JavaUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithOrganisationTEST 
{
public static void main(String[] args) throws EncryptedDocumentException, IOException 
{
	
	WebDriver driver=null;
 	 ExcelUtilities excelutil = new ExcelUtilities();
 	 FileUtilities fileutil = new FileUtilities();
 	 JavaUtility javautil = new JavaUtility();
 	 
 	 //get properties of property file using getproperty method
 	 String USERNAME = fileutil.getPropertyKeyValue("username");
 	 String PASSWORD = fileutil.getPropertyKeyValue("password");
 	 String BROWSER = fileutil.getPropertyKeyValue("browser");
 	 String URL = fileutil.getPropertyKeyValue("url");
 	 
 	 //TO GET RANDOM NUMBER
 	 int randumnum = javautil.getRandomNumber();
 	 
 	 //Fething first name from excel
 	 String FIRSTNAME = excelutil.ReadExceldataValue("sheet1", 1, 2);
 	 
 	 //Fetching last name
 	 String LASTNAME = excelutil.ReadExceldataValue("sheet1", 1, 3);
 	 
 	 //Fetching phone number from excel
 	 String MOBILENUMBER = excelutil.ReadExceldataValue("sheet2", 1, 0);
 	 
 	 String ORGANISATIONNAME = excelutil.ReadExceldataValue("sheet2", 1, 1);
 	 
 	 //Launch th ebrowser
 	 if(BROWSER.equals("firefox"))
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
 	driver.findElement(By.xpath("(//a[.='Organizations'])[1]")).click();
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(ORGANISATIONNAME+randumnum);
	WebElement indstry_dd = driver.findElement(By.xpath("//select[@name='industry']"));
	Select sel=new Select(indstry_dd);
	sel.selectByValue("Engineering");
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	WebElement text = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
	String expect_orgnisation_name = text.getText();
	if(expect_orgnisation_name.contains(ORGANISATIONNAME))
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
	driver.findElement(By.name("firstname")).sendKeys(FIRSTNAME);
	driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
	driver.findElement(By.name("mobile")).sendKeys(MOBILENUMBER);
	driver.findElement(By.xpath("(//img[@language='javascript'])[1]")).click();
	Set<String> ids = driver.getWindowHandles();
	ArrayList<String> windowids=new ArrayList<String>(ids);
	String child_window = windowids.get(1);
	driver.switchTo().window(child_window);
	driver.findElement(By.id("search_txt")).sendKeys("test");
	driver.findElement(By.name("search")).click();
	driver.findElement(By.xpath("//a[.='SAMSUNG.INDIA PVT.LTD']")).click();
	String parentid = windowids.get(0);
	driver.switchTo().window(parentid);
	driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
	WebElement contactdetails = driver.findElement(By.id("tblContactInformation"));
	String actualcontactinfo = contactdetails.getText();
	String expectenumber=MOBILENUMBER;
	if(actualcontactinfo.contains(expectenumber))
	{
		System.out.println("contact and organisation is successfully created");
	}
	else
	{
		System.out.println("contact and organisation is not created");
	}
}
}
