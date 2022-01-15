package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Creating New Contact 
 * @author Mamatha
 *
 */

public class CreatingNewContactPage {
	
	//decleration of elemnts
	@FindBy(name ="lastname")
	private WebElement lastnameTextField;
	
	@FindBy(xpath="//img[@alt='Select']")
	private WebElement orgNameLookUpPlusButton;
	
	
	@FindBy(xpath="//input[@alt='Clear']")
	private WebElement orgNameClearImg;
	
	@FindBy(name="button")
	private WebElement saveButton;
	
	@FindBy(name="donotcall")
	private WebElement doNotCallCheckBox;
	
	@FindBy(name="emailoptout")
	private WebElement emailOptOutCheckBox;
	
	@FindBy(name="reference")
	private WebElement referenceCheckBox;
	
	//inisalization of elements
	public CreatingNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//business logics 
	
	/**
	 * this method is used to enter last name text field
	 * @param lastname
	 */
	public void lastnameTextField(String lastname) {
		lastnameTextField.sendKeys(lastname);
	}
	
	/**
	 * this method is used to click on org Name Look Up Plus Button
	 */
	public void orgNameLookUpPlusButton()
	{
		orgNameLookUpPlusButton.click();
	}
	
	/**
	 * this method is used to clear text in org Name text feild
	 */
	public void clickOnOrgNameClearImg()
	{
		orgNameClearImg.click();
	}
	
	/**
	 * this method is used to click on save button 
	 */
	public void clickOnSaveButton()
	{
		saveButton.click();
	}
	
	/**
	 * this method is used to click on  Do Not Call Check Box
	 */
	public void clickOnDoNotCallCheckBox() {
		doNotCallCheckBox.click();
	}
	
	/**
	 * this method is used to click on Email Opt Out CheckBox
	 */
	public void clickOnEmailOptOutCheckBox()
	{
		emailOptOutCheckBox.click();
	}
	
	/**
	 * this method is used to click on click On Reference CheckBox
	 */
	public void clickOnReferenceCheckBox() {
		referenceCheckBox.click();
	}
	
	
	//getter method
	
	public WebElement getLastnameTextField() {
		return lastnameTextField;
	}

	public WebElement getOrgNameLookUpPlusButton() {
		return orgNameLookUpPlusButton;
	}

	public WebElement getOrgNameClearImg() {
		return orgNameClearImg;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getDoNotCallCheckBox() {
		return doNotCallCheckBox;
	}

	public WebElement getEmailOptOutCheckBox() {
		return emailOptOutCheckBox;
	}

	public WebElement getReferenceCheckBox() {
		return referenceCheckBox;
	}
	
	
	
	
	
	
}
