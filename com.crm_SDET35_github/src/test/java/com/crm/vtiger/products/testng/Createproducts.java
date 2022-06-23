package com.crm.vtiger.products.testng;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
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

public class Createproducts extends Baseclass 
{
	@Test(groups = "smoke")
	public void createproducts() throws Throwable

{
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
    //clicking on productlink
    home.getProductLNK().click();
    //clicking on create product button in productpage
    prodct.getCreateproductBTN().click();
    //entering first name into first name text field
    prodct.enterproductname(PRODUCTNAME);
    //selecting product category in 'product category drop-down'
    prodct.selectproductcategory(opt2);
    //click on save button
    prodct.getSaveBTN().click();
    //fetching product information in table
    String pr = prodct.selectproductinformation();
    if(pr.contains(PRODUCTNAME))
    {
    	System.out.println("product is created");
    }
    else
    {
    	System.out.println("product is not created");
    }
    
	
}
}
