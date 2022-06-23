package com.crm.vtiger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mysql.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckIfDataiIsStoredInDatabaseTEST 
{

	public static void main(String[] args) throws InterruptedException, SQLException 
	{
		String projectcopy = "prowork";
      System.setProperty("webdriver.gecko.driver", "./src/main/resources/geckodriver.exe");
     WebDriver driver = new FirefoxDriver();
     driver.get("http://localhost:8084");
     driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
     driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
     driver.findElement(By.xpath("//button[.='Sign in']")).click();
     Thread.sleep(2000);
     driver.findElement(By.xpath("//a[.='Projects']")).click();
     Thread.sleep(2000);
     driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
     Thread.sleep(2000);
     driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys("prowork");
     Thread.sleep(2000);
     driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("pradeep");
     Thread.sleep(2000);
     WebElement dd = driver.findElement(By.xpath("//select[@name='status']"));
     Thread.sleep(2000);
      Select sel = new Select(dd);
      sel.selectByValue("Created");
      driver.findElement(By.xpath("//input[@value='Add Project']")).click();
      driver.close();
      Driver driverref = new Driver();
      DriverManager.registerDriver(driverref);
      Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
      Statement statement = connection.createStatement();
      String query = "select * from project";
      ResultSet result = statement.executeQuery(query);
      while(result.next())
      {
    	  String actualproject = result.getString(4);
    	  if(projectcopy.equals(actualproject))
    	  {
    		  System.out.println("project is present");
    		  break;
    	  }
    	  else
    	  {
    		  System.out.println("project is not present");
    		  break;
    	  }
      }
      connection.close();
	}
}
