package com.crm.vtiger.campaignTestng;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.objectrepository.Campaign_PAGE;
import com.crm.objectrepository.Homepage;
import com.crm.objectrepository.LoginPage;
import com.crm.objectrepository.Morelnk_PAGE;
import com.crm.objectrepository.ProductPAGE;

import generic_utilities.Baseclass;
import generic_utilities.ExcelUtilities;
import generic_utilities.FileUtilities;
import generic_utilities.IpathConstants;
import generic_utilities.JavaUtility;
import generic_utilities.WebdriverUtilities;

public class CreateCampaignTest extends Baseclass
{
	@Test(groups = {"smoke"})
	public  void createCampaigntest() throws EncryptedDocumentException, IOException
	{
    //home page object
   Homepage home = new Homepage(driver);
   
   //click on more
   WebElement Mmorelnk = home.getMorELNKDD();
   
   //movto more lnk element
   webLIB.mouseOverActions(driver, Mmorelnk);
   
   //click on campaign lnk
   home.getCampaignLNK().click();
  
   //campaign page object
   Campaign_PAGE camppag = new Campaign_PAGE(driver);
   webLIB.WaitForPageToLoad(driver);
 
   //click on create campaign
   camppag.getCreatecampaignBTN().click();
   
   //fetch campaign name from excel sheet
   String campaignname = excelLIB.ReadExceldataValue("sheet2", 1, 5);
   
   //rando no
   int randno = javaLIB.getRandomNumber();
   
   //entercampaign name
   camppag.getEntercampaignnameTXTFLD().sendKeys(campaignname+randno);
   
   //click on save
   camppag.getclickonsaveBTN().click();
   
   //verify
   String campnin = camppag.getcampaigninformation();
   String camp = campnin.toString();
   System.out.println(camp);
   
   Assert.assertTrue(camp.contains(campaignname));
   
//   if(camp.contains(campaignname))
//   {
//	   System.out.println("campaign is created");
//   }
//   else
//   {
//	   System.out.println("campaign name is not created");
//   }
   

}
}
