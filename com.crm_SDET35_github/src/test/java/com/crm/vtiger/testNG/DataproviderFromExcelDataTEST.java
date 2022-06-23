package com.crm.vtiger.testNG;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import generic_utilities.ExcelUtilities;

public class DataproviderFromExcelDataTEST 
{
	
	@Test(dataProvider = "airlinesticket")
	public void bookticketTest(String from, String to,String seatno)
	{
		System.out.println("from"+" "+from+" "+"to"+" "+to+" "+"seatno"+" "+seatno);
	}
	@DataProvider()
	public  Object[][] airlinesticket() throws EncryptedDocumentException, IOException

	{
		ExcelUtilities excelutil = new ExcelUtilities();
		String from = excelutil.ReadExceldataValue("sheet3", 1, 0);
		String to = excelutil.ReadExceldataValue("sheet3", 1, 1);
		String seatno = excelutil.ReadExceldataValue("sheet3",1, 2);
		
		String from1 = excelutil.ReadExceldataValue("sheet3", 2, 0);
		String to1 = excelutil.ReadExceldataValue("sheet3", 2, 1);
		String seatno1 = excelutil.ReadExceldataValue("sheet3",2, 2);
		
		String from2 = excelutil.ReadExceldataValue("sheet3", 3, 0);
		String to2 = excelutil.ReadExceldataValue("sheet3", 3, 1);
		String seatno2 = excelutil.ReadExceldataValue("sheet3",3, 2);
		
		String from3 = excelutil.ReadExceldataValue("sheet3", 4, 0);
		String to3 = excelutil.ReadExceldataValue("sheet3", 4, 1);
		String seatno3 = excelutil.ReadExceldataValue("sheet3",4, 2);
		
		
		Object[][] object = new Object[4][3];
		
		object[0][0]=from;
		object[0][1]=to;
		object[0][2]=seatno;
		
		object[1][0]=from1;
		object[1][1]=to1;
		object[1][2]=seatno1;
		
		object[2][0]=from2;
		object[2][1]=to2;
		object[2][2]=seatno2;
		
		object[3][0]=from3;
		object[3][1]=to3;
		object[3][2]=seatno3;
		
		return object;
		
		
	}
	
	{
		
	}
	

}
