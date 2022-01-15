package contactTest;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.comcast.GenricUtility.ExcelUtility;
import com.crm.comcast.GenricUtility.FileUtility;
import com.crm.comcast.GenricUtility.IpathConstant;
import com.crm.comcast.GenricUtility.JavaUtility;
import com.crm.comcast.GenricUtility.WebDriverUtility;
import com.crm.comcast.objectRepository.ContactInfomationPage;
import com.crm.comcast.objectRepository.ContactsPage;
import com.crm.comcast.objectRepository.CreatingNewContactPage;
import com.crm.comcast.objectRepository.HomePage;
import com.crm.comcast.objectRepository.LoginPage;
import com.crm.comcast.objectRepository.OrganizationLookUpPage;
/**
 * 
 * @author mamatha
 *
 */
public class CreateContactTC_21Test {
	
	
	/**
	 * create contact with required field
	 * @param args
	 * @throws Throwable
	 */

	public static void main(String[] args) throws Throwable {
		
		//object creation for utilies
		FileUtility fUtil= new FileUtility();
		ExcelUtility Exelutil = new ExcelUtility();
		JavaUtility jUtil = new JavaUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		
		
		// getting data from property file
		String browser = fUtil.getPropertyFileData("browser");
		String url = fUtil.getPropertyFileData("url");
		String username = fUtil.getPropertyFileData("username");
		String password = fUtil.getPropertyFileData("password");
		
		
		// getting data from excel sheet
		String lastname = Exelutil.getStringCellData("sheet1", 6, 2);
		String childWindowURL = Exelutil.getStringCellData("sheet1", 6, 3);
		String parentWindowURL = Exelutil.getStringCellData("sheet1", 6, 4);
		
		/*FileInputStream fisexcel=new FileInputStream("./src/test/resources/data.xlsx");
		Workbook workbook = WorkbookFactory.create(fisexcel);
		Sheet sheet = workbook.getSheet("sheet1");
		String lastname = sheet.getRow(8).getCell(1).getStringCellValue();*/
				
    
		//launch browser
		
		WebDriver driver=null;
		
		if(browser.equals("chrome"))
		{
			System.setProperty(IpathConstant.CHROME_DRIVER_KEY, IpathConstant.CHROME_DRIVER_PATH);
			driver=new ChromeDriver();
		}
		
		else
		{
			System.out.println("browser not supported");
		}
		
		driver.manage().window().maximize();
		driver.get(url);
		
		/***********implicitly wait statement taken from webDriver Utility*****************/
		wUtil.waitForPageToLoad(driver);
		
		
		
		//loginpage
		LoginPage loginPage= new LoginPage(driver);
		loginPage.loginToApplication(username,password);
		
		//home page
		HomePage homePage =new HomePage(driver);
		homePage.clickOnContactsLink();;
		
		//contact page
		ContactsPage contactsPage= new ContactsPage(driver);
		contactsPage.clickOnCreateContactPlusImg();
		
		//create new contact
		CreatingNewContactPage newContact = new CreatingNewContactPage(driver);
		newContact.lastnameTextField(lastname);
		newContact.orgNameLookUpPlusButton();
		
		
		//organization look up switch and switch back window
		OrganizationLookUpPage OrgLookUpPage = new OrganizationLookUpPage(driver);
		OrgLookUpPage.clickOnOrgNameLink(childWindowURL, parentWindowURL);
		
		//create new contact
		newContact.clickOnOrgNameClearImg();
		newContact.clickOnSaveButton();
		
		
		//Contact Infomation Page
		ContactInfomationPage contactInfo = new ContactInfomationPage(driver);
		String actualText = contactInfo.contactInfoText();
		
		
		//verifying created contact title 
		
		if(actualText.contains(lastname))
		{
			System.out.println("contact created and verified");
		}
		else
		{
			System.out.println("contact not created");
		}
		
		//logout
		homePage.logout();
		
		driver.quit();   

	}

}
