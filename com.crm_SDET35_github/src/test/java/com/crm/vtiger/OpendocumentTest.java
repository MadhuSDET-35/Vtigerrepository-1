package com.crm.vtiger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpendocumentTest 
{
public static void main(String[] args) throws InterruptedException 
{
	System.setProperty("webdriver.gecko.driver", "./src/main/resources/geckodriver.exe");
	WebDriver driver=new FirefoxDriver();
	driver.get("http://localhost:8888/");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@type='text']")).sendKeys("admin");
	Thread.sleep(2000);
	driver.findElement(By.name("user_password")).sendKeys("admin");
	Thread.sleep(2000);
	driver.findElement(By.id("submitButton")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[.='Documents']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//img[@alt='Create Document...']")).click();
	Thread.sleep(2000);
	driver.findElement(By.name("notes_title")).sendKeys("vtiger project");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@value='T']")).click();
	Thread.sleep(2000);
	driver.findElement(By.name("filename")).sendKeys("I:\\SELENIUM.jfif");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	Thread.sleep(2000);
	WebElement key = driver.findElement(By.xpath("//td[.='Document Information']"));
	String text = key.getText();
	System.out.println(text);
	if(text.contains("Document Information"))
	{
		System.out.println("test case is pass");
	}
	else
	{
		System.out.println("test case is fail");
	}
	}
	
}
