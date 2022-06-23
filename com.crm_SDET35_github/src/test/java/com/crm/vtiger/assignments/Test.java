package com.crm.vtiger.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test 
{
	public static void main(String[] args) throws InterruptedException 
	{
	System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("C://Users/MADHUSUDAN/Desktop/bindu.html");
	Thread.sleep(2000);
	driver.findElement(By.tagName("input")).clear();
	
	}

}
