package com.crm.vtiger;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AnimalType 
{
	@Test(retryAnalyzer = generic_utilities.RetryAnalyserImpl.class)
	public void elephant()
	{
		Reporter.log("big",true);
		Assert.fail();
	}
}
