package com.crm.vtiger.products;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.crm.objectrepository.Homepage;
import com.crm.objectrepository.LoginPage;
import com.crm.objectrepository.Morelnk_PAGE;
import com.crm.objectrepository.ProductPAGE;
import com.crm.objectrepository.Vendors_PAGE;
import com.crm.objectrepository.vendors_childwindow_PAGE;

import generic_utilities.ExcelUtilities;
import generic_utilities.FileUtilities;
import generic_utilities.JavaUtility;
import generic_utilities.WebdriverUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProductWithVendors 
{
 public static void main(String[] args) throws IOException 
 {
	 
	//Object creation of utility file
	JavaUtility javautil=new JavaUtility();
	ExcelUtilities excelutil = new ExcelUtilities();
	FileUtilities fileutil = new FileUtilities();
	WebdriverUtilities webutil = new WebdriverUtilities();
	
	  //fetching the data from property file
      String USERNAME = fileutil.getPropertyKeyValue("username");
      String PASSWORD = fileutil.getPropertyKeyValue("password");
      String BROWSER = fileutil.getPropertyKeyValue("browser");
      String URL = fileutil.getPropertyKeyValue("url");
      
      
      //random no
      int randomno = javautil.getRandomNumber();
      
      //fetching datas from excel file
 
      String vendorpagename = excelutil.ReadExceldataValue("sheet2", 1, 8);
      System.out.println(vendorpagename);
      
      WebDriver driver=null;
      if(BROWSER.equalsIgnoreCase("chrome"))
      {
    	  WebDriverManager.chromedriver().setup();
    	  driver=new ChromeDriver();
    	  
      }
      else if(BROWSER.equalsIgnoreCase("firefox"))
      {
    	  WebDriverManager.firefoxdriver().setup();
    	  driver=new FirefoxDriver();
      }
      
      driver.get(URL);
      
       //object for loginpage
       LoginPage loginpg = new LoginPage(driver);
       
       //enter username
       loginpg.getUsernameTXTFLD().sendKeys(USERNAME);
       
       //enter password
       loginpg.getPasswordTXTFLD().sendKeys(PASSWORD);
       
       //click login button
       loginpg.getSubmitBTN().click();
       
       //click on more dropdown
       //object for homepage
       Homepage homepg = new Homepage(driver);
       
       //click on morelink
       homepg.getMorELNKDD().click();
       
       //create an object for link
       Morelnk_PAGE morepg = new Morelnk_PAGE(driver);
       
       //click on vendorsling
       morepg.clickonvendorsLNK();
       
       //object creation for vendors page
       Vendors_PAGE vendorspg = new Vendors_PAGE(driver);
       
       //fetch vendorsname from excel
       String VENDORNAME = excelutil.ReadExceldataValue("sheet2", 1, 7);
       
       //create vendor
       vendorspg.entervendorsname_and_save(VENDORNAME+randomno);
       
       //verification of vendors name
       if(vendorspg.vendorsinformation().contains(VENDORNAME))
       {
    	  System.out.println("vendor is successfully created");
       }
       else
       {
    	  System.out.println("vendors is not created");
       }
     
      //click on product link
      homepg.getProductLNK().click();
      
      //creation object for product page
      ProductPAGE prodpg = new ProductPAGE(driver);
      
      //click on create new product
      prodpg.getCreateproductBTN().click();
      
      //fetch product name from excel
      String PRODUCTNAME = excelutil.ReadExceldataValue("sheet2", 1, 2);
      
      //enter product name
      prodpg.getproductnameTXTFLD().sendKeys(PRODUCTNAME+randomno);
      
      //click on vendor name
      prodpg.getSelectvendorIMGBTN().click();
      
    //switch to vendor child window
      webutil.switchToWindow(driver, "Vendors&action");
      
      //enter vendor name
     prodpg.getEntervendorsnameTXTFLD().sendKeys("SAMSUNG");
     
     //CLICK ON SEARCH BTN
     prodpg.getClickonvendorsearchBTN().click();
     
     //select vendors
     prodpg.getSelectvendor().click();
     
     //switch to main
     webutil.switchToWindow(driver, "Products&action");
     
     //click on save
       prodpg.getSaveBTN().click();
       
       
     
     
    }   
}
