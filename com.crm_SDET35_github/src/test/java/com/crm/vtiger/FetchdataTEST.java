package com.crm.vtiger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class FetchdataTEST 
{

	public static void main(String[] args) throws SQLException 
	{
	Driver driverreference = new Driver();
	DriverManager.registerDriver(driverreference);
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
	Statement statement = connection.createStatement();
	String query = "select * from project";
	ResultSet result = statement.executeQuery(query);
	System.out.println(result);
	while(result.next())
	{
		System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4));
	}
	connection.close();
	

	}

}
