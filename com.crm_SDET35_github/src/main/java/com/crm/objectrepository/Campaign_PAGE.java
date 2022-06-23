package com.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;

import generic_utilities.WebdriverUtilities;

public class Campaign_PAGE extends WebdriverUtilities
{
@FindBy(xpath = "//img[@title='Create Campaign...']") private WebElement createcampaignBTN;
@FindBy(name = "campaignname") private WebElement entercampaignnameTXTFLD;
@FindBy(xpath = "//img[@alt='Select']") private WebElement selectproductBTN;
@FindBy(name = "search_text") private WebElement enterproductnameTXTFLD;
@FindBy(name = "search") private WebElement searchBTN;
@FindBy(linkText = "SAMSUNG_SS555") private WebElement selectproduct;
@FindBy(xpath = "//input[@class='crmButton small save']") private WebElement clickonsaveBTN;
@FindBy(xpath = "//span[@class='dvHeaderText']") private WebElement campaigninformation;
@FindBy(id = "tblCampaignInformation") private WebElement campaigntableinformationTBL;

public WebElement getCampaigntableinformationTBL() {
	return campaigntableinformationTBL;
}

public Campaign_PAGE(WebDriver driver)
{
	PageFactory.initElements(driver, this);
	
}

public WebElement getCreatecampaignBTN() 
{
	return createcampaignBTN;
}

public WebElement getEntercampaignnameTXTFLD()
{
	return entercampaignnameTXTFLD;
}

public WebElement getSelectproductBTN() 
{
	return selectproductBTN;
}

public WebElement getEnterproductnameTXTFLD() 
{
	return enterproductnameTXTFLD;
}

public WebElement getSearchBTN() 
{
	return searchBTN;
}

public WebElement getSelectproduct() 
{
	return selectproduct;
}

public WebElement getclickonsaveBTN()
{
	return clickonsaveBTN;
}
WebdriverUtilities webutil=new WebdriverUtilities();
public void enterCampaignName_Select_product_and_Save(String campaignname,WebDriver driver,String childwindowname,String productname,String parentwindow )
{
	entercampaignnameTXTFLD.sendKeys(campaignname);
	selectproductBTN.click();
	webutil.switchToWindow(driver, childwindowname);
	enterproductnameTXTFLD.sendKeys(productname);
	searchBTN.click();
	selectproduct.click();
	webutil.switchToWindow(driver, parentwindow);
}

public String getcampaigninformation()
{
	 String campaininformation = campaigninformation.getText();
	 return campaininformation;
}






}
