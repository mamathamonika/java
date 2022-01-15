package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ExecuteUpdateUsingJDBCTest {

	public static void main(String[] args) throws SQLException {
		
		
		Connection connection=null;
		try
		{
					
		// register connection
		
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		// establish connection between 
		
		 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo", "root", "root");
		
		// create statement 
		Statement statement = connection.createStatement();
		
		//modify data in database 
		
		int result = statement.executeUpdate("insert into student values(104,'CEN','MATH');");
		
		//verification
		
		if (result == 1)
		{
			System.out.println("data updated in database");
		}
		
		else
		{
			System.out.println("data not updated in database");
		}
		
		}
		
		catch (Exception e) {


		}
		
		finally {
			
		//close connection 
		
		connection.close();
		}

	}

}
