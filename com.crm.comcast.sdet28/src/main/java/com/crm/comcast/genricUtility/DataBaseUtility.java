package com.crm.comcast.genricUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Result;
import com.mysql.jdbc.Driver;

public class DataBaseUtility 
{
	Connection connection=null;
	/**
	 * Thid method will do the connction to database
	 * @throws Throwable
	 */
	public void connectionToDB() throws Throwable
	{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		connection=DriverManager.getConnection("","","");
	
	}
	
	/**
	 * this method will close the database connection
	 * @throws SQLException
	 */
	public void closedDB() throws SQLException
	{
		connection.close();
	}
	
	/**
	 * Method will fetch the data from database
	 * @param querry
	 * @return
	 * @throws Throwable 
	 */
	public ResultSet getAllData(String querry) throws Throwable
	{
		ResultSet result=connection.createStatement().executeQuery(querry);
		return result;
	}
	/**
	 * method will update the data from the database
	 * @param querry
	 * @return
	 * @throws Throwable
	 */
	public boolean updateDate(String querry) throws Throwable
	{
		boolean flag=false;
		int result=connection.createStatement().executeUpdate(querry);
		if(result==1)
		{
			System.out.println("data is updated in database");
			flag=true;
		}
		else
		{
			System.out.println("data is not updated in database");
		}
		return flag;
	}
	
	/**
	 * This method will verify the given data is present in the database or not
	 * @param querry
	 * @param columnNumber
	 * @param expectedData
	 * @return
	 * @throws Throwable
	 */
	public String getTheData(String querry,int columnNumber, String expectedData) throws Throwable
	{
		boolean flag=false;
		String actualData=null;
		ResultSet result=connection.createStatement().executeQuery(querry);
		while(result.next())
		{
			String data=result.getString(columnNumber);
			if(data.equals(expectedData))
			{
				actualData=data;
				flag=true;
				break;
			}
		}
		if(flag==true)
		{
			System.out.println("data is present in the database");
			return actualData;
		}
		else
		{
			System.out.println("data is not present in the database");
			return actualData;
		}
	}

}
