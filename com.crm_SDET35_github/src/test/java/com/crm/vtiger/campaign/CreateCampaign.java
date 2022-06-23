package com.crm.vtiger.campaign;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.objectrepository.Campaign_PAGE;
import com.crm.objectrepository.Homepage;
import com.crm.objectrepository.LoginPage;
import com.crm.objectrepository.Morelnk_PAGE;
import com.crm.objectrepository.ProductPAGE;

import generic_utilities.ExcelUtilities;
import generic_utilities.FileUtilities;
import generic_utilities.IpathConstants;
import generic_utilities.JavaUtility;
import generic_utilities.WebdriverUtilities;

public class CreateCampaign
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
    
    System.setProperty(IpathConstants.GECKOKEY,IpathConstants.GECKOPATHVALUE);
    WebDriver driver=new FirefoxDriver();
    webut.WaitForPageToLoad(driver);
    driver.get(URL);
    //login page object 
   LoginPage log=new LoginPage(driver);
   //home page object
   Homepage home = new Homepage(driver);
   //product page object
   ProductPAGE prodct = new ProductPAGE(driver);
   //campaign page object
   Campaign_PAGE camppag = new Campaign_PAGE(driver);
   webut.WaitForPageToLoad(driver);
  //login to application entering username and password 
   log.Logintoapplication(USERNAME, PASSWORD);
  //click on more
   WebElement Mmorelnk = home.getMorELNKDD();
   
   //movto more lnk element
   webut.mouseOverActions(driver, Mmorelnk);
   
   //click on campaign lnk
   home.getCampaignLNK().click();
   
   //click on create campaign
   camppag.getCreatecampaignBTN().click();
   
   //fetch campaign name from excel sheet
   String campaignname = excelut.ReadExceldataValue("sheet2", 1, 5);
   
   //rando no
   int randno = javaut.getRandomNumber();
   
   //entercampaign name
   camppag.getEntercampaignnameTXTFLD().sendKeys(campaignname+randno);
   
   //click on save
   camppag.getclickonsaveBTN().click();
   
   //verify
   String campnin = camppag.getcampaigninformation();
   String camp = campnin.toString();
   System.out.println(camp);
   
   if(camp.contains(campaignname))
   {
	   System.out.println("campaign is created");
   }
   else
   {
	   System.out.println("campaign name is not created");
   }
   

}
}
