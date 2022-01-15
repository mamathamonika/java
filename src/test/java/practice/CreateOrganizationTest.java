package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class CreateOrganizationTest {

	public static void main(String[] args) throws Throwable {

       FileInputStream fis =new FileInputStream("./src/test/resources/data.properties");
       Properties property = new Properties();
       property.load(fis);
       String browser = property.getProperty("browser");
       String url = property.getProperty("url");
       String username = property.getProperty("username");
       String password = property.getProperty("password");
       
       WebDriver driver = null;
       
       if(browser.equals("chrome"))
       {
    	   System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
    	   driver=new ChromeDriver();
       }
       
       else if(browser.equals("firfox"))
       {
    	   System.setProperty("webdriver.gecko.driver","./src/main/resources/geckodriver.exe");
    	   driver=new FirefoxDriver();
       }
       
       else
       {
    	   System.out.println("browesr not found");
       }
       
       driver.manage().window().maximize();
       driver.get(url);
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       
       driver.findElement(By.name("user_name")).sendKeys(username);
       driver.findElement(By.name("user_password")).sendKeys(password);
       driver.findElement(By.id("submitButton")).click();
       
       driver.findElement(By.linkText("Organizations")).click();
       driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
       driver.findElement(By.name("accountname")).sendKeys("TY1");
       driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
       
       WebElement orgtext = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
       String text = orgtext.getText();
       
       if (text.contains("TY"))
       {
    	   
    	   System.out.println("organization is created");
       }
       
       else
       {
    	   System.out.println("organization is not created");

       }
       
       
       WebElement mouseover = driver.findElement(By.xpath("//img[@style='padding: 0px;padding-left:5px']"));
		
       Actions action = new Actions(driver);
       
       action.moveToElement(mouseover).perform();
       
       driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
       
       driver.quit();
       
	}

}
