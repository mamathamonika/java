package com.crm.comcast.GenricUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;

/**
 * 
 * @author Mamatha
 *
 */

public class DataBaseUtility {
	Connection connection = null;
	
	/**
	 * this method establish connection to database
	 * @throws Throwable
	 */
	
	public void connectToDB() throws Throwable {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		connection = DriverManager.getConnection(IpathConstant.DATABASE_URL,"root","root");
	}
	
	
	/**
	 * this method closes database
	 * @throws Throwable
	 */
	
	public void closeDB() throws Throwable {
		connection.close();
	}
	
	/**
	 * this method get data from database
	 * @param query
	 * @return
	 * @throws Throwable
	 */
	
	public ResultSet getAllData(String query) throws Throwable {
		ResultSet result = connection.createStatement().executeQuery(query);
		return result;
	}
	
	/**
	 * this method is used to modify data in database and verifies 
	 * @param query
	 * @return
	 * @throws Throwable
	 */
	
	public boolean updateData(String query) throws Throwable {
		int result = connection.createStatement().executeUpdate(query);
		boolean flag = false;
		if(result==1)
		{
			System.out.println("data is updated in database");
			return true;
		}
		else
		{
			System.out.println("data is not updated in database");
			return false;
		}
	}
	
	/**
	 * this method is used to verify the given data in present in database or not  and returns actualdata
	 * @param query
	 * @param columnNum
	 * @param expectedData
	 * @return
	 * @throws Throwable
	 */
	
	public String getTheData(String query, String columnNum, String expectedData) throws Throwable {
		String actualData=null;
		boolean flag = false;
		ResultSet result = connection.createStatement().executeQuery(query);
		while(result.next())
		{
			String data = result.getString(columnNum);
			if (data.equals(expectedData))
			{
				actualData=data;
				flag= true;
				break;
			}
		}
			if(flag==true)
			{
				System.out.println("data is present in database");
				return actualData;
			}
			else
			{
				System.out.println("data is not present in database");
				return actualData;
			}
		}
	}

