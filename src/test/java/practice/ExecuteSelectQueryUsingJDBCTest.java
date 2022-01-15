package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ExecuteSelectQueryUsingJDBCTest {

	public static void main(String[] args) throws SQLException {
		
		//regester drive
		
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		// estabish connection between java and database
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo", "root", "root");
		
		//create statement
		
            Statement statement = connection.createStatement();
        // execute query
            
          ResultSet result = statement.executeQuery("select *  from student;");
            
         // print result 
          
          while(result.next())
          {
        	  System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3));
          }
         
          //close connection
          
          connection.close();
         
            
            
		
	

	}

}
