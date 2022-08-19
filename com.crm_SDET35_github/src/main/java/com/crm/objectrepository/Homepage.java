package com.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utilities.WebdriverUtilities;

public class Homepage extends WebdriverUtilities
{
@FindBy(linkText = "Organizations")
private WebElement organisationLNK;

@FindBy(linkText ="Contacts" )
private WebElement contactLNK;

@FindBy(linkText = "Products")
private WebElement productLNK;

@FindBy(xpath = "//img[@src='themes/softed/images/menuDnArrow.gif']")
private WebElement morELNKDD;

@FindBy(name = "Campaigns")
private WebElement campaignLNK;

@FindBy(name = "Vendors")
private WebElement vendorsLNK;

@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']") private WebElement logoutfromapplication;

@FindBy(linkText = "Sign Out")private WebElement cliconSignoutLNK;







public Homepage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public WebElement getOrganisationLNK() 
{
	return organisationLNK;
}

public WebElement getContactLNK() 
{
	return contactLNK;
}

public WebElement getProductLNK() 
{
	return productLNK;
}

public WebElement getMorELNKDD() 
{
	return morELNKDD;
}

public WebElement getCampaignLNK() 
{
	return campaignLNK;
}

public WebElement getvendorsLNK()
{
	return vendorsLNK;
}
public WebElement getLogoutfromapplication() 
{
	return getLogoutfromapplication();
}

public WebElement getCliconSignoutLNK() {
	return cliconSignoutLNK;
}

//utilization

public void signoutfromapplication(WebDriver driver)
{
	mouseOverActions(driver,logoutfromapplication);
	cliconSignoutLNK.click();
}












}
