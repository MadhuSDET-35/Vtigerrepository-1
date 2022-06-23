package com.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	//declaration
	
	@FindBy(name = "user_name")
	private WebElement usernameTXTFLD;

	@FindBy(name = "user_password")
	private WebElement passwordTXTFLD;
	
	@FindBy(id = "submitButton")
	private WebElement submitBTN;
	
	//initialization
	
	public LoginPage(WebDriver driver)
	
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	
    public WebElement getUsernameTXTFLD() 
	
	{
		return usernameTXTFLD;
	}

	public WebElement getPasswordTXTFLD() 
	
	{
		return passwordTXTFLD ;
	}

	public WebElement getSubmitBTN() 
	
	{
		return submitBTN;
	}
	
	public void Logintoapplication(String username,String password)
	{
		usernameTXTFLD.sendKeys(username);
		passwordTXTFLD.sendKeys(password);
		submitBTN.click();
	}
	
	
	
	
	
	

}
