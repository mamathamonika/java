package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * login page 
 * @author Mamatha
 *
 */

public class LoginPage {
	
	
	//Declaration of elements
	@FindBy(name="user_name")
	private WebElement usernameTextField;
	
	@FindBy(name="user_password")
	private WebElement passwordTextField;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;
	
	//inisalization of elements
	
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}

	
	//getter method 
	public WebElement getUsernameTextField() {
		return usernameTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	
	//businees logic
	
	/**
	 * this method is used to login to the application
	 * @param username
	 * @param password
	 */
	public void loginToApplication(String username, String password)
	{
		usernameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		loginButton.click();
	}
	
	
	
	
	

}
