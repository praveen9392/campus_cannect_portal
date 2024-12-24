package com.example.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection
{
	Connection conn;
	public Connection getConnection() 
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/campus_cannect_portal","root","Prathyusha1@");
		} 
		catch (Exception e)
		{
			System.out.println(e.getMessage());

		}
		return conn;
	}
}
