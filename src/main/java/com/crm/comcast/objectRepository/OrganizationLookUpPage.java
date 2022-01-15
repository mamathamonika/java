package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.GenricUtility.WebDriverUtility;

/**
 * Organization Look Up Page
 * @author Mamatha
 *
 */
public class OrganizationLookUpPage extends WebDriverUtility {
	WebDriver driver;
	
	
	//decliration of elements
	@FindBy(xpath="//a[@href=\"javascript:window.close();\"]")
	private WebElement orgNameLink;
	
	
	///inisalization of elements
	public OrganizationLookUpPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	
	//business logics
	
	/**
	 * this method switch window and click on orgname and switch back window
	 * @throws InterruptedException 
	 */
	public void clickOnOrgNameLink(String childWindowURL, String parentWindowURL) throws InterruptedException
	{
		alterSwitchWindow(driver,childWindowURL);
		orgNameLink.click();
		Thread.sleep(5000);
		alterSwitchWindow(driver,parentWindowURL);
	}
	

	
}
