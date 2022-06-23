package com.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;

public class vendors_childwindow_PAGE 
{
	@FindBy(id = "search_txt") private WebElement entervendornameTXTFLD;
	@FindBy(name = "search") private WebElement clickonsearchBTN;
	@FindBy(linkText = "SAMSUNGVENDOR") private WebElement clickonvendornameLNK;
	
	
	public vendors_childwindow_PAGE(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getEntervendornameTXTFLD() 
	{
		return entervendornameTXTFLD;
	}
	
	public WebElement getclickonsearchBTN()
	{
		return clickonsearchBTN;
	}
	
   public WebElement getclickonvendornameLNK()
   {
	   return clickonvendornameLNK;
   }
   
   
   public void entervendornameTXTFLD(String childwendorname)
   {
	   entervendornameTXTFLD.sendKeys(childwendorname);
	   
   }
	
	
	

}
