package com.crm.vtiger;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class OpenBrowser 
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
driver.findElement(By.xpath("//a[.='Products']")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
Thread.sleep(2000);
driver.findElement(By.name("productname")).sendKeys("vtiger_product1");
Thread.sleep(2000);
WebElement dd = driver.findElement(By.xpath("//select[@name='productcategory']"));
Select sel=new Select(dd);
sel.selectByVisibleText("Software");
Thread.sleep(2000);
WebElement manufact = driver.findElement(By.name("manufacturer"));
Select sel1=new Select(manufact);
sel1.selectByValue("MetBeat Corp");
driver.findElement(By.xpath("//input[@value='T']")).click();
driver.findElement(By.id("my_file_element")).sendKeys("I:\\SELENIUM.jfif");
Thread.sleep(2000);
driver.findElement(By.name("description")).sendKeys("hi this is selenium test yantra project product");
Thread.sleep(2000);
driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
Thread.sleep(2000);
WebElement key = driver.findElement(By.xpath("//td[.='Product Information']"));
String text = key.getText();
System.out.println(text);
if(text.contains("Product Information"))
{
	System.out.println("test case is pass");
}
else
{
	System.out.println("test case is fail");
}
}

}
