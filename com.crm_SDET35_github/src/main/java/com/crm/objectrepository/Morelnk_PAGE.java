package com.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Morelnk_PAGE 
{
	@FindBy(name = "Vendors") private WebElement vendorLNK;
	@FindBy(id = "Campaigns") private WebElement campaignLNK;
	
	public Morelnk_PAGE(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getvendorsLNK()
	{
		return vendorLNK;
	}
	
	public void clickonvendorsLNK()
	{
		vendorLNK.click();
	}

	public WebElement getCampaignLNK() {
		return campaignLNK;
	}
	

}
