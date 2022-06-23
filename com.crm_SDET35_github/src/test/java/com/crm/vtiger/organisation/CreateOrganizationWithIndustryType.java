package com.crm.vtiger.organisation;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.objectrepository.ContactPAGE;
import com.crm.objectrepository.Homepage;
import com.crm.objectrepository.LoginPage;
import com.crm.objectrepository.OrganisationPAGE;

import generic_utilities.ExcelUtilities;
import generic_utilities.FileUtilities;
import generic_utilities.IpathConstants;
import generic_utilities.JavaUtility;
import generic_utilities.WebdriverUtilities;

public class CreateOrganizationWithIndustryType 
{
public static void main(String[] args) throws IOException 
{
	 FileUtilities filut=new FileUtilities();
     ExcelUtilities excelut=new ExcelUtilities();
     JavaUtility javaut =new JavaUtility();
     WebdriverUtilities webut=new WebdriverUtilities();
     
     //fetching datas from property file
     String USERNAME = filut.getPropertyKeyValue("username");
     String PASSWORD = filut.getPropertyKeyValue("password");
     String URL = filut.getPropertyKeyValue("url");
     String BROWSER = filut.getPropertyKeyValue("browser");	
     
     int randomno = javaut.getRandomNumber();
     
     
     System.setProperty(IpathConstants.GECKOKEY,IpathConstants.GECKOPATHVALUE);
     WebDriver driver=new FirefoxDriver();
     webut.WaitForPageToLoad(driver);
     driver.get(URL);
     //login page object 
    LoginPage log=new LoginPage(driver);
    
    //Enter username
    log.getUsernameTXTFLD().sendKeys(USERNAME);
    
    //Enter Password
    log.getPasswordTXTFLD().sendKeys(PASSWORD);
    
    //click on subbmit button
    log.getSubmitBTN().click();
    
    //create an object for Home page
   Homepage hompg = new Homepage(driver);
   
   //click on organisation link
   hompg.getOrganisationLNK().click();
   
   //create object for organisationpage
  OrganisationPAGE organisationpg = new OrganisationPAGE(driver);
   
   //import organisation name from excel
   String organisationname = excelut.ReadExceldataValue("sheet2", 1, 1);
   System.out.println(organisationname);
   
   //click on create new organization
   organisationpg.clickonneworganisationIMGBTN();
   
   //enter organization name
   organisationpg.getEnterorganisationnameTXTFLD().sendKeys(organisationname);
   
   //select industry 
   WebElement industry = organisationpg.getIndustryDROPDN();
   
   //select industry
   webut.selectDropDown(industry, "Banking");
   
   //select type
   WebElement typedd = organisationpg.getTypeDRPDN();
   
   //select type value
   webut.selectDropDown(typedd, "Analyst");
   
   //click on save
   organisationpg.getClickonsaveBTN().click();
   
   //verification
    String tableallinfo = organisationpg.getTableinformation().getText();
   
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