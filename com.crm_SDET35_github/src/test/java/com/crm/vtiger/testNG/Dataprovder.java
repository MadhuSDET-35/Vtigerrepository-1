package com.crm.vtiger.testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataprovder
{
@Test(dataProvider = "booktickets")
public void bookticket(String src,String dst)
{
	System.out.println("from"+src+"to"+dst);
}
@DataProvider()
public Object[][] booktickets()
{
Object[][]	objarr=new Object[3][2];
objarr[0][0]="bangalore";
objarr[0][1]="mangalore";

objarr[1][0]="mumbai";
objarr[1][1]="dubai";

objarr[2][0]="goa";
objarr[2][1]="kerala";


return objarr;




}
}
