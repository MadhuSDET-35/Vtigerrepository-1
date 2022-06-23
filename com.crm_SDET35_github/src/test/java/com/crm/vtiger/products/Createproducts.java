package com.crm.vtiger.products;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.objectrepository.Campaign_PAGE;
import com.crm.objectrepository.Homepage;
import com.crm.objectrepository.LoginPage;
import com.crm.objectrepository.ProductPAGE;

import generic_utilities.ExcelUtilities;
import generic_utilities.FileUtilities;
import generic_utilities.IpathConstants;
import generic_utilities.JavaUtility;
import generic_utilities.WebdriverUtilities;

public class Createproducts 
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
     String childwindow_name = "Products&action";
     String parent_window_name="Campaigns&action";
     
     //fetch data from excelfile
     String PRODUCTNAME = excelut.ReadExceldataValue("sheet2", 1, 2);
     String CAMPAIGNNAME = excelut.ReadExceldataValue("sheet2", 1, 5);
     String opt1 = excelut.ReadExceldataValue("sheet2", 1, 6);
     String opt2 = excelut.ReadExceldataValue("sheet2", 2, 6);
     String opt3 = excelut.ReadExceldataValue("sheet2", 3, 6);
     String opt4= excelut.ReadExceldataValue("sheet2", 4, 6);
     
    
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
