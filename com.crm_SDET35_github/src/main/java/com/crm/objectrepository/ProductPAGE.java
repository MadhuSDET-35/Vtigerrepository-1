package com.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utilities.WebdriverUtilities;

public class ProductPAGE  extends WebdriverUtilities
{
@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")private WebElement createproductBTN;

@FindBy(name = "productname") private WebElement productnameTXTFLD;

@FindBy(name = "productcategory") private WebElement productcategoryDD;


@FindBy(xpath = "//input[@title='Save [Alt+S]']") private WebElement saveBTN;

@FindBy(xpath = "//span[@class='lvtHeaderText']") private WebElement productinformation;

@FindBy(xpath = "//img[@alt='Select']") private WebElement selectvendorIMGBTN;

@FindBy(name = "search_text") private WebElement entervendorsnameTXTFLD;

@FindBy(name = "search") private WebElement clickonvendorsearchBTN;

@FindBy(xpath = "//a[.='SAMSUNGVENDOR730']") private WebElement selectvendor;

public WebElement getSelectvendor() {
	return selectvendor;
}

public ProductPAGE(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public WebElement getEntervendorsnameTXTFLD() {
	return entervendorsnameTXTFLD;
}

public WebElement getClickonvendorsearchBTN() {
	return clickonvendorsearchBTN;
}

public WebElement getCreateproductBTN()
{
	return createproductBTN;
}

public WebElement getproductnameTXTFLD()
{
	return productnameTXTFLD;
}

public WebElement getProductcategoryDD() 
{
	return productcategoryDD;
}

public WebElement getSaveBTN() 
{
	return saveBTN;
}

public WebElement getproductinformationtable()
{
	return productinformation;
}

public void enterproductname(String productname)
{
	productnameTXTFLD.sendKeys(productname);
}

public void selectproductcategory(String procategory)
{
	selectDropDown(productcategoryDD, procategory);
}

public String selectproductinformation()
{
	String producttext = productinformation.getText();
	return producttext;
	
}

public WebElement getSelectvendorIMGBTN() 
{
	return selectvendorIMGBTN;
}





}





