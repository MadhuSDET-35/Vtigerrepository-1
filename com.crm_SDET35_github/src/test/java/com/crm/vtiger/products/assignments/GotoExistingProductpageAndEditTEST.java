package com.crm.vtiger.products.assignments;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GotoExistingProductpageAndEditTEST 
{
	public static void main(String[] args) throws IOException 
	{
		//FETCHING DATAS FROM PROPERTY FILE
				FileInputStream fis=new FileInputStream("src/main/resources/prop.properties");
				Properties prop = new Properties();
				prop.load(fis);
				String URL = prop.getProperty("url");
				String USERNAME = prop.getProperty("username");
				String PASSWORD = prop.getProperty("password");
				String BROWSER = prop.getProperty("browser");	
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
				driver.findElement(By.name("selected_id")).click();
				driver.findElement(By.xpath("//a[.='edit']")).click();
	}

}
