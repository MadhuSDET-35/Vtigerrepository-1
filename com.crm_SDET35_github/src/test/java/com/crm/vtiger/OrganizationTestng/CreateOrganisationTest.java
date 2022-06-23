package com.crm.vtiger.OrganizationTestng;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.objectrepository.Homepage;
import com.crm.objectrepository.LoginPage;
import com.crm.objectrepository.OrganisationPAGE;

import generic_utilities.Baseclass;
import generic_utilities.ExcelUtilities;
import generic_utilities.FileUtilities;
import generic_utilities.IpathConstants;
import generic_utilities.JavaUtility;
import generic_utilities.WebdriverUtilities;

public class CreateOrganisationTest extends Baseclass
{
@Test(groups = "smoke")

public void createorganizationTest() throws Throwable
{
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
   
   //click on create new organisation
   organisationpg.clickonneworganisationIMGBTN();
   
   //fail script
   Assert.fail();
  
   //click on create new organisation
   organisationpg.getEnterorganisationnameTXTFLD().sendKeys(organisationname+randomno);
   
   //click on save button
   organisationpg.getClickonsaveBTN().click();
   
   
   //verification of organisation name
   String oraganisationnameforverify = organisationpg.getorganisationonformationforVERIFY().getText();
   
   
   
   
//   if(oraganisationnameforverify.contains(organisationname+randomno))
//   {
//	   System.out.println("organistion is created");
//   }
//   else
//   {
//	   System.out.println("organisation is not created");
//   }
//   
}
}
