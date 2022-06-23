package com.crm.vtiger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class InsertDataToDatabase 
{
public static void main(String[] args) throws SQLException 
{
Driver driverreference = new Driver();	
DriverManager.registerDriver(driverreference);
Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
Statement statement = connection.createStatement();
String query = " insert into project values('TY_PROJ_64','MADHU','19/04/1996','AMAZON','STARTED', '5')";
int RESULT = statement.executeUpdate(query);
if(RESULT==1)
{
	System.out.println("is created");
}
else
{
	System.out.println("is not created");
}

}
}
