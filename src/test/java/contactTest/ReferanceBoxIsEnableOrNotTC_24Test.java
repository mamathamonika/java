package contactTest;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.comcast.GenricUtility.FileUtility;
import com.crm.comcast.GenricUtility.WebDriverUtility;
import com.crm.comcast.objectRepository.ContactsPage;
import com.crm.comcast.objectRepository.CreatingNewContactPage;
import com.crm.comcast.objectRepository.HomePage;
import com.crm.comcast.objectRepository.LoginPage;

/**
 * 
 * @author Mamatha
 *
 */
public class ReferanceBoxIsEnableOrNotTC_24Test {

	/**
	 * to check Referance Box Is Enable Or Not in contact module TC_24Test
	 * @param args
	 * @throws Throwable
	 */
	public static void main(String[] args) throws Throwable {

		//object creation for utilies
		FileUtility fUtil = new FileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		
		
		// getting data from property file
		String browser = fUtil.getPropertyFileData("browser");
		String url = fUtil.getPropertyFileData("url");
		String username = fUtil.getPropertyFileData("username");
		String password = fUtil.getPropertyFileData("password");
		
		
		//launching browser
		
		WebDriver driver=null;
		
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else
		{
			System.out.println("Do not call box is not enabled");
		}
		
		driver.manage().window().maximize();
		driver.get(url);
		/***********implicitly wait statement taken from webDriver Utility*****************/
		wUtil.waitForPageToLoad(driver);
		
		//loginpage 
		LoginPage loginPage= new LoginPage(driver);
		loginPage.loginToApplication(username,password);
		
		//homepage
		HomePage homePage = new HomePage(driver);
		homePage.clickOnContactsLink();
		
		//contacts page
		ContactsPage contactsPage =new ContactsPage(driver);
		contactsPage.clickOnCreateContactPlusImg();
		
		//create new contact page
		CreatingNewContactPage newContactPage = new CreatingNewContactPage(driver);
		
		
		if(newContactPage.getReferenceCheckBox().isEnabled())
		{
			System.out.println("ref check box is enabled");
			newContactPage.clickOnReferenceCheckBox();
		}
		
		else
		{
			System.out.println("ref check box is not enabled");
		}
		
		//logout

		homePage.logout();
		
		driver.quit();
	}

}
