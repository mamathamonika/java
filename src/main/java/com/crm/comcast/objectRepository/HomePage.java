package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.GenricUtility.WebDriverUtility;

/**
 * home page
 * @author Mamatha
 *
 */
public class HomePage extends WebDriverUtility{
	
	WebDriver driver;
	
	//declaration of elements
	
	@FindBy(linkText ="Organizations")
	private WebElement organizationLink;
	
	@FindBy(linkText ="Contacts")
	private WebElement ContactsLink;
	
	@FindBy(linkText ="Opportunities")
	private WebElement OpportunitiesLink;
	
	@FindBy(linkText ="Products")
	private WebElement ProductsLink;
	
	@FindBy(linkText ="Documents")
	private WebElement DocumentsLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement logoutImg;
	
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signOutLink;
	
	
	//inisalization of elements
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	
	// getter methods
	
	public WebElement getOrganizationLink() {
		return organizationLink;
	}


	public WebElement getContactsLink() {
		return ContactsLink;
	}


	public WebElement getOpportunitiesLink() {
		return OpportunitiesLink;
	}


	public WebElement getProductsLink() {
		return ProductsLink;
	}


	public WebElement getDocumentsLink() {
		return DocumentsLink;
	}
	
		
	public WebElement getLogoutImg() {
		return logoutImg;
	}


	public WebElement getSignOutLink() {
		return signOutLink;
	}

	
	//business logic

	/**
	 * this method is used to click on organizationLink
	 */
	
	public void clickOnOrganizationLink() {
		organizationLink.click();
		}
	

	/**
	 * this method is used to click on ContactsLink
	 */
	public void clickOnContactsLink() {
		ContactsLink.click();
		}
	

	/**
	 * this method is used to click on OpportunitiesLink
	 */
	public void clickOnOpportunitiesLink() {
		OpportunitiesLink.click();
		}
	

	/**
	 * this method is used to click on ProductsLink
	 */
	public void clickOnProductsLink() {
		ProductsLink.click();
		}
	

	/**
	 * this method is used to click on DocumentsLink
	 */
	public void clickOnDocumentsLink() {
		DocumentsLink.click();
		}
	
	/**
	 * this method is used to logout of aplication
	 */
	public void logout()
	{
		mouseHover(driver, logoutImg);
		signOutLink.click();
	
	}
	
	

}
