package com.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utilities.WebdriverUtilities;

public class Vendors_PAGE extends WebdriverUtilities
{
@FindBy(xpath = "//img[@alt='Create Vendor...']") private WebElement createventorIMGBTN;
@FindBy(name = "vendorname") private WebElement vendernameTXTFLD;
@FindBy(xpath = "//input[@class='crmbutton small save']") private WebElement saveBTN;
@FindBy(xpath = "//span[@class='lvtHeaderText']") private WebElement vendorsinformation;
@FindBy(id = "search_txt") private WebElement entervendornameTXTFLD;


public WebElement getEntervendornameTXTFLD() 
{
	return entervendornameTXTFLD;
}


public Vendors_PAGE(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public WebElement getCreateventorIMGBTN() {
	return createventorIMGBTN;
}

public WebElement getVendernameTXTFLD() {
	return vendernameTXTFLD;
}

public WebElement getSaveBTN() {
	return saveBTN;
}
public WebElement getvendorsinformation()
{
	return vendorsinformation;
}

/*public WebElement getclickonvendorLNK()
{
	return clickonvendorLNK;
}*/
public void entervendorsname_and_save(String vendors_name)
{
	createventorIMGBTN.click();
	vendernameTXTFLD.sendKeys(vendors_name);
	saveBTN.click();
}

public String vendorsinformation()
{
	String vendorsINFO = vendorsinformation.getText();
     return	vendorsINFO ;
}
}


