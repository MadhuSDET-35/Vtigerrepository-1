package com.crm.vtiger.testNG;



import org.testng.Assert;
import org.testng.annotations.Test;

public class Testng1 
{
@Test()
public void elephantTEST()
{
	System.out.println("BIG ANIMAL");
	Assert.fail();
}
@Test(dependsOnMethods = "elephantTES")
public void dogTEST()
{
	System.out.println("MEDIUM ANIMAL");
}
@Test(invocationCount = 1)
public void snakTEST()
{
	System.out.println("SMALL ANIMAL");
}

}
