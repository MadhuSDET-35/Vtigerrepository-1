package com.crm.vtiger.products.assignments;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoToProductCreatingPageAndNevigateToProductImageInformationTEST {

	public static void main(String[] args) throws IOException 
	{
		//Fetching data from property file
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
	    driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	    driver.get(URL);
	    driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[.='Products']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		//Actions act=new Actions(driver);
         WebElement y = driver.findElement(By.name("file_0"));
         Point loc = y.getLocation();
         System.out.println(loc);
		JavascriptExecutor jss=(JavascriptExecutor)driver;
		jss.executeScript("window.scrollBy(427, 974)","");
		driver.findElement(By.id("my_file_element")).sendKeys("I:\\FOLDER\\IMAGE1.jpg");
		driver.findElement(By.id("my_file_element")).sendKeys("I:\\FOLDER\\IMAGE2.jpg");
		driver.findElement(By.id("my_file_element")).sendKeys("I:\\FOLDER\\IMAGE3.jpg");
	    driver.findElement(By.id("my_file_element")).sendKeys("I:\\FOLDER\\IMAGE4.jpg");
		driver.findElement(By.id("my_file_element")).sendKeys("I:\\FOLDER\\IMAGE5.jpg");
		driver.findElement(By.id("my_file_element")).sendKeys("I:\\FOLDER\\IMAGE6.jpg");
		driver.findElement(By.id("my_file_element")).sendKeys("I:\\FOLDER\\IMAGE7.jpg");
		driver.findElement(By.id("my_file_element")).sendKeys("I:\\FOLDER\\IMAGE8.jpg");
		
	}

}
