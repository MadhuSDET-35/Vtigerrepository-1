package com.crm.vtiger.OrganizationTestng;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.objectrepository.ContactPAGE;
import com.crm.objectrepository.Homepage;
import com.crm.objectrepository.LoginPage;
import com.crm.objectrepository.OrganisationPAGE;

import generic_utilities.Baseclass;
import generic_utilities.ExcelUtilities;
import generic_utilities.FileUtilities;
import generic_utilities.IpathConstants;
import generic_utilities.JavaUtility;
import generic_utilities.WebdriverUtilities;

public class CreateOrganizationWithIndustryType  extends Baseclass
{
@Test(groups = "regression")
public void  CreateorganizationwithIndustrytype() throws IOException
{
     //fetching datas from property file
     String USERNAME = filLIB.getPropertyKeyValue("username");
     String PASSWORD = filLIB.getPropertyKeyValue("password");
     String URL = filLIB.getPropertyKeyValue("url");
     String BROWSER = filLIB.getPropertyKeyValue("browser");	
     
     int randomno = javaLIB.getRandomNumber();
     //create an object for Home page
   Homepage hompg = new Homepage(driver);
   
   //click on organisation link
   hompg.getOrganisationLNK().click();
   
   //create object for organisationpage
  OrganisationPAGE organisationpg = new OrganisationPAGE(driver);
   
   //import organisation name from excel
   String organisationname = excelLIB.ReadExceldataValue("sheet2", 1, 1);
   System.out.println(organisationname);
   
   //click on create new organization
   organisationpg.clickonneworganisationIMGBTN();
   
   //enter organization name
   organisationpg.getEnterorganisationnameTXTFLD().sendKeys(organisationname+randomno);
   
   //select industry 
   WebElement industry = organisationpg.getIndustryDROPDN();
   
   //select industry
   webLIB.selectDropDown(industry, "Bankin");
   
   //select type
   WebElement typedd = organisationpg.getTypeDRPDN();
   
   //select type value
   webLIB.selectDropDown(typedd, "Analyst");
   
   //click on save
   organisationpg.getClickonsaveBTN().click();
   
   //verification
    String tableallinfo = organisationpg.getTableinformation().getText();
    System.out.println(tableallinfo);
   
   if(tableallinfo.contains("Banking"))
   {
	   System.out.println("industry is created");
   }
   else
   {
	   System.out.println("industry is not created");
   }
   
   if (tableallinfo.contains("Analyst")) 
   {
	System.out.println("type is created");
	   System.out.println("organization is created with type and industry");
	   
   }
   else
   {
	   System.out.println("type is not created");
	  
   }
   
   
}

}