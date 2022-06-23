package com.crm.vtiger.assignments;

import java.util.stream.IntStream;

public class Date 
{
public static void main(String[] args) 
{
	java.util.Date dat=new java.util.Date();
	String date = dat.toString();
	String yyyy = date.split(" ")[5];
	String dd = date.split(" ")[2];
       int d = dat.getMonth()+1;
	
	System.out.println(yyyy+" "+dd+" "+d);
}
}
