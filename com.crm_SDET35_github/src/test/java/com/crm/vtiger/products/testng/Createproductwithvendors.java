package com.crm.vtiger.products.testng;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.objectrepository.Campaign_PAGE;
import com.crm.objectrepository.Homepage;
import com.crm.objectrepository.LoginPage;
import com.crm.objectrepository.ProductPAGE;
import com.mysql.cj.jdbc.Driver;

import generic_utilities.Baseclass;
import generic_utilities.ExcelUtilities;
import generic_utilities.FileUtilities;
import generic_utilities.IpathConstants;
import generic_utilities.JavaUtility;
import generic_utilities.WebdriverUtilities;

public class Createproductwithvendors extends Baseclass
{
@Test(groups = "regression")
public void createproductwithvendors() throws Throwable
{
    
     
     //fetching datas from property file
   
     String childwindow_name = "Products&action";
     String parent_window_name="Campaigns&action";
     
     //fetch data from excelfile
     String PRODUCTNAME = excelLIB.ReadExceldataValue("sheet2", 1, 2);
     String CAMPAIGNNAME = excelLIB.ReadExceldataValue("sheet2", 1, 5);
     String opt1 = excelLIB.ReadExceldataValue("sheet2", 1, 6);
     String opt2 = excelLIB.ReadExceldataValue("sheet2", 2, 6);
     String opt3 = excelLIB.ReadExceldataValue("sheet2", 3, 6);
     String opt4= excelLIB.ReadExceldataValue("sheet2", 4, 6);
     
    //home page object
    Homepage home = new Homepage(driver);
    //product page object
    ProductPAGE prodct = new ProductPAGE(driver);
    //campaign page object
    Campaign_PAGE camppag = new Campaign_PAGE(driver);
    webLIB.WaitForPageToLoad(driver);
  
    //clicking on productlink
    home.getProductLNK().click();
    //clicking on create product button in productpage
    prodct.getCreateproductBTN().click();
    //entering first name into first name text field
    prodct.enterproductname(PRODUCTNAME);
    //selecting product category in 'product category drop-down'
    prodct.selectproductcategory(opt2);
   
    //Click on select vendors img btn
    prodct.getSelectvendorIMGBTN().click();
    
    //switch to vendors child window
    webLIB.switchToWindow(driver, "Vendors&action");
    
    //enter vendors name
    prodct.getEntervendorsnameTXTFLD().sendKeys("SAMSUNG");
    
    //Clic on search btn
    prodct.getClickonvendorsearchBTN().click();
    
    //select vendors
    prodct.getSelectvendor().click();
    
    //switch to product page
    webLIB.switchToWindow(driver, "Products&action");
    
    //click on save button
    prodct.getSaveBTN().click();
    
    //fetching product information in table
    String pr = prodct.selectproductinformation();
    if(pr.contains(PRODUCTNAME))
    {
    	System.out.println("product is created with vendors");
    }
    else
    {
    	System.out.println("product is not created");
    }
//    //selecting more dropdown in home page
//    WebElement mr = home.getMorELNKDD();
//    webLIB.mouseOverActions(driver, mr);
//    //selecting campaign link
//    home.getCampaignLNK().click();
//    //Click on create campaign BTN
//    camppag.getCreatecampaignBTN().click();
//    //entercampaign name and select product and click
//    camppag.enterCampaignName_Select_product_and_Save(CAMPAIGNNAME, driver, childwindow_name, PRODUCTNAME, parent_window_name);
//    //click on save button
//    camppag.getclickonsaveBTN().click();
//    //verify that campaign is created or not
//     if(camppag.getcampaigninformation().contains(CAMPAIGNNAME))
//     {
//    	 System.out.println("campaign name is created");
//     }
//     else
//     {
//    	 System.out.println("campaign name is not created");
//     }
}
}






     
    

    
    
    
    
     
     
     
     
     
     
     
     
     
     
     /*driver.findElement(By.name("user_name")).sendKeys(USERNAME);
    driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
 driver.findElement(By.id("submitButton")).click();
     driver.findElement(By.xpath("//a[.='Products']")).click();
     driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
     driver.findElement(By.name("productname")).sendKeys(PRODUCTNAME);
     WebElement PRODUCT_CATEGORY_DD = driver.findElement(By.name("productcategory"));
     webut.selectDropDown(PRODUCT_CATEGORY_DD, "Software");
     driver.findElement(By.xpath("//input[@type='submit']")).click();
     WebElement productinforefvar = driver.findElement(By.id("tblProductInformation"));
     String productsinfolist = productinforefvar.getText();
     if(productsinfolist.contains(PRODUCTNAME))
     {
    	 System.out.println("product is created");
     }
     else
     {
    	 System.out.println("product is not created");
     }
     WebElement moreelement = driver.findElement(By.xpath("//a[.='More']"));
     webut.mouseOverActions(driver, moreelement);
     driver.findElement(By.name("Campaigns")).click();
     driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
     driver.findElement(By.name("campaignname")).sendKeys(CAMPAIGNNAME);
     driver.findElement(By.xpath("//img[@title='Select']")).click();
     webut.switchToWindow(driver, "Products&action");
     driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(PRODUCTNAME);
     driver.findElement(By.xpath("//a[.='SAMSUNG_SS555']")).click();
     webut.switchToWindow(driver, "Campaigns&action");
     driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();*/
    
   
     
     
     


