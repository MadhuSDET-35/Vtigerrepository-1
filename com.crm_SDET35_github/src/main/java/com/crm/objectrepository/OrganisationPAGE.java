package com.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationPAGE
{
	
	@FindBy(xpath = "//img[@alt='Create Organization...']") private WebElement createneworganisationIMGBTN;
	@FindBy(name = "accountname") private WebElement enterorganisationnameTXTFLD;
	@FindBy(name = "button") private WebElement clickonsaveBTN;
	@FindBy(xpath = "//span[@class='lvtHeaderText']") private WebElement organisationonformationforVERIFY;
	@FindBy(name = "industry") private WebElement industryDROPDN;
	@FindBy(name = "accounttype") private WebElement typeDRPDN;
	@FindBy(xpath = "//div[@id='tblOrganizationInformation']//tr[7]//td[2]") private WebElement tableindustryinfo;
	@FindBy(xpath = "//div[@id='tblOrganizationInformation']//tr[8]//td[2]") private WebElement tabletypeinfo;
	@FindBy(id = "tblOrganizationInformation") private WebElement tableinformation;
	
	public WebElement getTableinformation() {
		return tableinformation;
	}

	public WebElement getTableindustryinfo() {
		return tableindustryinfo;
	}

	public WebElement getTabletypeinfo() {
		return tabletypeinfo;
	}

	public OrganisationPAGE(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateneworganisationIMGBTN() 
	{
		return createneworganisationIMGBTN;
	}

	public WebElement getEnterorganisationnameTXTFLD() 
	{
		return enterorganisationnameTXTFLD;
	}

	public WebElement getClickonsaveBTN() 
	{
		return clickonsaveBTN;
	}
	
	public WebElement getorganisationonformationforVERIFY()
	{
	return	organisationonformationforVERIFY;
	}
	
	public void clickonneworganisationIMGBTN()
	{
		createneworganisationIMGBTN.click();
	}

	public WebElement getIndustryDROPDN() {
		return industryDROPDN;
	}

	public WebElement getTypeDRPDN() {
		return typeDRPDN;
	}
	
	
	

}
