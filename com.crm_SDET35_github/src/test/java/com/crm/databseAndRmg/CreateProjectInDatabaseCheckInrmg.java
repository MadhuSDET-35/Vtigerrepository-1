package com.crm.databseAndRmg;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.mysql.jdbc.Driver;

public class CreateProjectInDatabaseCheckInrmg 
{
	public static void main(String[] args) throws IOException, SQLException 
	{
		//Fetching data from property file
		FileInputStream fis=new FileInputStream("src/main/resources/prop.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String DBUSENAME = prop.getProperty("dbusername");
		String DBPASSWORD = prop.getProperty("dbpassword");
		String DBURL = prop.getProperty("databaseurl");
		
		//fetching data from excel sheet
		FileInputStream fis1=new FileInputStream("src/main/resources/organisation_ass.xlsx");
		Workbook book=WorkbookFactory.create(fis1);
		Sheet sheet = book.getSheet("sheet1");
		Row row = sheet.getRow(1);
		Cell cell = row.getCell(5);
		String value = cell.getStringCellValue();
		System.out.println(value);
		
		Cell cell1= row.getCell(6);
		String projectid = cell1.getStringCellValue();
		System.out.println(projectid);
		
		Cell cell2 = row.getCell(7);
		String created_by = cell2.getStringCellValue();
		System.out.println(created_by);
		
		Cell cell3 = row.getCell(8);
		String created_date = cell3.getStringCellValue();
		System.out.println(created_date);
		
		Cell cell4 = row.getCell(9);
		String status = cell4.getStringCellValue();
		System.out.println(status);
		
		Cell cell5 = row.getCell(10);
        DataFormatter data=new DataFormatter();
        String teamsize = data.formatCellValue(cell5);
		System.out.println(teamsize);
		
	//creating project in database
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		Connection connect = DriverManager.getConnection(DBURL, DBUSENAME, DBPASSWORD);
		Statement state = connect.createStatement();
		String query = "insert into project values('"+projectid+"','"+created_by+"','"+created_date+"','"+status+"','"+teamsize+"')";
		int execute = state.executeUpdate(query);
		
		
		
		
		
		
	}

}
