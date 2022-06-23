package com.crm.vtiger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.bouncycastle.asn1.cmc.GetCert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.mysql.cj.jdbc.Driver;

public class CheckDataIsPresentInProject {

	public static void main(String[] args) throws SQLException, InterruptedException 
	{
   Driver referencedriver=new Driver();
   DriverManager.registerDriver(referencedriver);
   //getconnection
   Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
   //create statement
   Statement state = connect.createStatement();
   //write query
   String query = "insert into project values('TY_PROJ_401','MADHU','19/05/1996','big villa grand resort','STARTED', '6')";
   //Execute query
   int update = state.executeUpdate(query);
   System.out.println(update);
   if(update==1)
   {
	   System.out.println("is created");
   }
  else
   {
	   System.out.println("not created");
   }
   String projectname = "big villa grand resort";
   System.setProperty("webdriver.gecko.driver", "./src/main/resources/geckodriver.exe");
   WebDriver driver=new FirefoxDriver();
   driver.get("http://localhost:8084");
   driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
   driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
   driver.findElement(By.xpath("//button[.='Sign in']")).click();
   Thread.sleep(2000);
   driver.findElement(By.xpath("//a[.='Projects']")).click();
   Thread.sleep(2000);
   WebElement ele = driver.findElement(By.xpath("//table[@class='table table-striped table-hover']"));
   String text = ele.getText();
   //WebElement value = driver.findElement(By.xpath("//div[@class='col-sm-6']/../div[1]"));
  //String text = value.getText();
  //System.out.println(text);
  if(text.contains(projectname))
		  {
	  System.out.println("IS CREATED");
		  }
  else {
	System.out.println("IS NOT CREATED");
      }
}
}

