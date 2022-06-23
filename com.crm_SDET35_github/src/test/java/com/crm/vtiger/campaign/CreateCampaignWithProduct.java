package com.crm.vtiger.campaign;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.objectrepository.Campaign_PAGE;
import com.crm.objectrepository.Homepage;
import com.crm.objectrepository.LoginPage;
import com.crm.objectrepository.ProductPAGE;

import generic_utilities.Baseclass;
import generic_utilities.ExcelUtilities;
import generic_utilities.FileUtilities;
import generic_utilities.IpathConstants;
import generic_utilities.JavaUtility;
import generic_utilities.WebdriverUtilities;

public class CreateCampaignWithProduct extends Baseclass
{
	@Test
	public void createcampaignwithproduct() throws EncryptedDocumentException, IOException
	{
	
    
    //fetching datas from property file
    String USERNAME = filLIB.getPropertyKeyValue("username");
    String PASSWORD = filLIB.getPropertyKeyValue("password");
    String URL = filLIB.getPropertyKeyValue("url");
    String BROWSER = filLIB.getPropertyKeyValue("browser");
    
  
   Homepage home = new Homepage(driver);
   //product page object
   ProductPAGE prodct = new ProductPAGE(driver);
   //campaign page object
   Campaign_PAGE camppag = new Campaign_PAGE(driver);
   webLIB.WaitForPageToLoad(driver);
 
   WebElement Mmorelnk = home.getMorELNKDD();
   
   //movto more lnk element
   webLIB.mouseOverActions(driver, Mmorelnk);
   
   //click on campaign lnk
   home.getCampaignLNK().click();
   
   //click on create campaign
   camppag.getCreatecampaignBTN().click();
   
   //fetch campaign name from excel sheet
   String campaignname = excelLIB.ReadExceldataValue("sheet2", 1, 5);
   
   //rando no
   int randno = javaLIB.getRandomNumber();
   
   //entercampaign name
   camppag.getEntercampaignnameTXTFLD().sendKeys(campaignname+randno);
   
   //click on select product img btn
   camppag.getSelectproductBTN().click();
   
   //switch to product child window
   webLIB.switchToWindow(driver, "Products&action");
   
   //fetch product name
   String productname = excelLIB.ReadExceldataValue("sheet2", 1, 2);
   
   //enter product name
   camppag.getEnterproductnameTXTFLD().sendKeys(productname);
   
   //click on searchbtn
   camppag.getSearchBTN().click();
   
   //select product
   camppag.getSelectproduct().click();
   
   //switch back to main
   webLIB.switchToWindow(driver, "Campaigns&action");
   
   //click on save button
   camppag.getclickonsaveBTN().click();
   
   //verify
   WebElement info = camppag.getCampaigntableinformationTBL();
   String tableinfo = info.getText();
   if(tableinfo.contains(campaignname))
   {
	   System.out.println("campaign is created");
   }
   else
   {
	   System.out.println("campaign is not created");
   }
   
   if(tableinfo.contains(productname))
   {
	   System.out.println("product is created");
	   System.out.println("campaign is created with product");
   }
   else
   {
	   System.out.println("product is not created");
	   System.out.println("campaign is notcreated with product");
   }
}
}
