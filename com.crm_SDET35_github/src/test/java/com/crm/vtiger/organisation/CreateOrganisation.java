package com.crm.vtiger.organisation;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.objectrepository.Homepage;
import com.crm.objectrepository.LoginPage;
import com.crm.objectrepository.OrganisationPAGE;

import generic_utilities.ExcelUtilities;
import generic_utilities.FileUtilities;
import generic_utilities.IpathConstants;
import generic_utilities.JavaUtility;
import generic_utilities.WebdriverUtilities;

public class CreateOrganisation 
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
   
   //click on create new organisation
   organisationpg.clickonneworganisationIMGBTN();
  
   //click on create new organisation
   organisationpg.getEnterorganisationnameTXTFLD().sendKeys(organisationname+randomno);
   
   //click on save button
   organisationpg.getClickonsaveBTN().click();
   
   
   //verification of organisation name
   String oraganisationnameforverify = organisationpg.getorganisationonformationforVERIFY().getText();
   
   if(oraganisationnameforverify.contains(organisationname))
   {
	   System.out.println("organistion is created");
   }
   else
   {
	   System.out.println("organisation is not created");
   }
   
   
}
}
