package com.crm.vtiger.dropdowns;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetDropdownInReverseOrderTEST 
{
public static void main(String[] args) throws IOException 
{
	FileInputStream fis=new FileInputStream("src/main/resources/prop.properties");
    Properties prop=new Properties();
    prop.load(fis);
   
    String USERNAME = prop.getProperty("username");
    String PASSWORD = prop.getProperty("password");
    String URL = prop.getProperty("url");
    String BROWSER = prop.getProperty("browser");
    
    WebDriver driver=null;
    
    if(BROWSER.equalsIgnoreCase("Firefox"))
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
	WebElement usageunitdropdown = driver.findElement(By.name("usageunit"));
	Select sel = new Select(usageunitdropdown);
	List<WebElement> options = sel.getOptions();
	TreeSet<String> set=new TreeSet<String>();
	//for(WebElement alloptions:options)	
}
}
