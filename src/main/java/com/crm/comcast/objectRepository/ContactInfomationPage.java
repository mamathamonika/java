package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * Contact Infomation Page displayed after creating contact
 * @author Mamatha
 *
 */

public class ContactInfomationPage {
	
	//deleration of elements
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement contactInfoText;
	
	//inisalization of elements
	public ContactInfomationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	//business logic
	/**
	 * this method gives contact Info Text after creating contact
	 * @return
	 */
	public String contactInfoText()
	{
		return contactInfoText.getText();
	}

}
