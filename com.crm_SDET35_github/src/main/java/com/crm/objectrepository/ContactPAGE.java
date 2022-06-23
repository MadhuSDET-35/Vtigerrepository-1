package com.crm.objectrepository;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.jsoup.internal.FieldsAreNonnullByDefault;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPAGE 
{
@FindBy(xpath = "//img[@title='Create Contact...']") private WebElement clickoncreatenewcontactIMGBTN;
@FindBy(name = "firstname") private WebElement enterfirstnameTXTFLD;
@FindBy(name = "lastname")private WebElement enetrlastnameTXTFLD;
@FindBy(xpath = "//table[@class='small']//tr[5]//td[2]//img") WebElement clickonorganosationnameIMGBTN;
@FindBy(id = "search_txt") WebElement enterorganisationnameTXTFLD;
@FindBy(name = "search") WebElement clikonsearctBTN;
@FindBy(xpath = "//a[.='SAMSUNG.INDIA PVT.LTD59']")WebElement selectroganisationLNK;
@FindBy(id = "mobile") WebElement enterphonenoTXTFLD;
@FindBy(xpath = "//input[@class='crmButton small save']") WebElement clickonsaveBTN;
@FindBy(name = "salutationtype") WebElement firstnameDD;
@FindBy(id = "tblContactInformation") WebElement tableinfoTBL;



public WebElement getTableinfoTBL() {
	return tableinfoTBL;
}

public WebElement getFirstnameDD() {
	return firstnameDD;
}

public WebElement getClickonsaveBTN() {
	return clickonsaveBTN;
}

public WebElement getEnterphonenoTXTFLD() {
	return enterphonenoTXTFLD;
}

public WebElement getSelectroganisationLNK() {
	return selectroganisationLNK;
}

public WebElement getEnterorganisationnameTXTFLD() {
	return enterorganisationnameTXTFLD;
}

public ContactPAGE(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public WebElement getClickoncreatenewcontactIMGBTN() {
	return clickoncreatenewcontactIMGBTN;
}

public WebElement getEnterfirstnameTXTFLD() {
	return enterfirstnameTXTFLD;
}

public WebElement getEnetrlastnameTXTFLD() {
	return enetrlastnameTXTFLD;
}

public WebElement getClickonorganosationnameIMGBTN() 
{
	return clickonorganosationnameIMGBTN;
		
}

public WebElement getClikonsearctBTN() {
	return clikonsearctBTN;
}


}
