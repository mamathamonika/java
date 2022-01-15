package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class GetTheDataFromPropertyTest {

	public static void main(String[] args) throws Throwable {
		
		//java representation of physical property file
		
		FileInputStream fis= new FileInputStream("./src/test/resources/data.properties");
		
		//create object for property class
		
		Properties properties =new Properties();
		
		//load key values from property file
		
		properties.load(fis);
		
		//fetch the values using respective key
		
		String browser = properties.getProperty("browser");
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
		
		

	}

}
