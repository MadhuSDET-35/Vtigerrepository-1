package com.crm.vtiger.assignments;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProductCamaignSaveTEST 
{
public static void main(String[] args) throws IOException 
{
	FileInputStream fis=new FileInputStream("src/main/resources/prop.properties");
	Properties prop = new Properties();
	prop.load(fis);	
	
String USERNAME = prop.getProperty("username");
String PASSWORD = prop.getProperty("password");
String URL = prop.getProperty("url");
String BROWSER = prop.getProperty("browser");
WebDriver driver=null;

String expected_product_name = "SAMSUNG_MOBILE_GH110";



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
driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
driver.get(URL);
driver.findElement(By.xpath("//input[@type='text']")).sendKeys(USERNAME);//Entering username
driver.findElement(By.name("user_password")).sendKeys(PASSWORD);//Entering password
driver.findElement(By.id("submitButton")).click();//click on submit button
driver.findElement(By.xpath("//a[.='Products']")).click();//clicking on products icon
driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();//creating product
driver.findElement(By.name("productname")).sendKeys("SAMSUNG_MOBILE_GH110");//entering product name
driver.findElement(By.name("file_0")).sendKeys("I:\\SELENIUM.jfif");//uploading file
driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();//saving
WebElement text = driver.findElement(By.xpath("//span[@class='lvtHeaderText']"));//verifying by fetching the product name
String actual_product_name = text.getText();
if(actual_product_name.contains(expected_product_name))
{
	System.out.println("product is created");
}
else
{
	System.out.println("product is not created");
}
WebElement moreelemet = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));//clicking on more icon
Actions act= new Actions(driver);
act.moveToElement(moreelemet).perform();
driver.findElement(By.name("Campaigns")).click();//clicking on campaigns 
driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();//creating campaign
driver.findElement(By.name("campaignname")).sendKeys("CAMPAIGN_SAMSUNG");//entering campaign name
driver.findElement(By.xpath("//img[@alt='Select']")).click();//linking products
Set<String> ids = driver.getWindowHandles();//switching to child window
ArrayList<String> ALLIDS = new ArrayList<String>(ids);
String child_id = ALLIDS.get(1);//switch to child window
driver.switchTo().window(child_id);//switched
driver.findElement(By.xpath("//a[.='SAMSUNG_MOBILE_GH110']")).click();//selecting teh product name
String parent_id = ALLIDS.get(0);//switching to parent window
driver.switchTo().window(parent_id);//switched to parent window
driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();//saving
WebElement campaininfo = driver.findElement(By.id("tblCampaignInformation"));//verifying by fetching the campaign info
String all_campaintext = campaininfo.getText();
if(all_campaintext.contains(expected_product_name))
{
	System.out.println("campaign is added successfully");
System.out.println("test case is pass");
}
else
{
	System.out.println("campaign is not added");
	System.out.println("test case is fail");
}
driver.close();


}
}
