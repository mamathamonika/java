package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * create contact page 
 * @author Mamatha
 *
 */

public class ContactsPage {
	
	//decleration of elements 
	
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement createContactPlusImg;
	
	
	
	//inisalization of elements
	
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//getter method
	public WebElement getCreateContactPlusImg() {
		return createContactPlusImg;
	}

	
	//business logics
	
	
	/**
	 * this method click on create Contact Plus Img
	 */
	public void clickOnCreateContactPlusImg() {
		createContactPlusImg.click();
	}
	
	
	

}
