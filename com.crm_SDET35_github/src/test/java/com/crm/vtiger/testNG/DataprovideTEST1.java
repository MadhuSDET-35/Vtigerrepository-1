package com.crm.vtiger.testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.collect.ObjectArrays;

public class DataprovideTEST1 
{
@Test(dataProvider = "booktrainticket")
public void bookticketsTEST(String SRC,String DST,int SEATNO)
{
	System.out.println("FROM"+" "+SRC+"TO"+" "+DST+" "+"SEATNO"+SEATNO);
}
@DataProvider()
public  Object[][] booktrainticket()
{
	Object[][] object = new Object[3][3];
	
	object[0][0]="BANGAORE";
	object[0][1]="MANGALORE";
	object[0][2]=19;
	
	object[1][0]="UDUPI";
	object[1][1]="GOA";
	object[1][2]=20;
	
	object[2][0]="GULBARGA";
	object[2][1]="RAICHUR";
	object[2][2]=21;
	
	
	
	return object;

}
}
