package com.crm.comcast.GenricUtility;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author Mamatha
 *
 */

public class WebDriverUtility {
	
	/**
	 * this method waits for 10sec for page to get load
	 * @param driver
	 */
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	
	/**
	 * this method waits till element is visible
	 * @param driver
	 * @param element
	 */
	public void waitForVisibilityOfElement(WebDriver driver, WebElement element) {
	
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * this method waits till element is clickable
	 * @param driver
	 * @param element
	 */
	
	public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * this method waits till element is clickable 
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitAndClick(WebElement element) throws InterruptedException {
		int count=0;
		while(count<10)
		{
			try
			{
				element.click();
			}
			catch (Exception e) {
				Thread.sleep(3000);
				count++;
			}
		}
	}
	
	/**
	 * this method gives option from dropdown by index
	 * @param element
	 * @param index
	 */
	public void selectOption(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
		
	/**
	 * this method gives option from dropdown by value
	 * @param element
	 * @param value
	 */
	public void selectOption(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
		
	}
	
	/**
	 * this method gives option from dropdown by text
	 * @param text
	 * @param element
	 */
	
	public void selectOption(String text, WebElement element ) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
		
	}
	
	/**
	 * this method is used to verfy dropdown options
	 * @param element
	 * @param expectedOtion
	 * @return
	 */
	public WebElement verifyDropDown(WebElement element, String expectedOption) {
		Select select =new Select(element);
		List<WebElement> dropdownopt = select.getOptions();
		for(WebElement ele:dropdownopt)
		{
			if(dropdownopt.equals(expectedOption))
			{
				System.out.println("expected option is present in drop down");
				return ele;
			}
			
			else
			{
				System.out.println("expected option is not present in drop down");
				return ele;
			}
		}
		return null;
	}
	
	/**
	 * this method used to perform mouse hover
	 * @param driver
	 * @param element
	 */
	public void mouseHover(WebDriver driver,WebElement element) {
		
		Actions action = new Actions (driver);
		action.moveToElement(element).perform();
		
	}
	
	/**
	 * this method is used to right click
	 * @param driver
	 * @param element
	 */
	
	public void rightClick(WebDriver driver,WebElement element) {
		
		Actions action = new Actions (driver);
		action.contextClick(element).perform();
		
	}
	
	/**
	 * this method is used to perform javascript lick on webelement
	 * @param driver
	 * @param element
	 */
		
	public void jsClick(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click", element);
	}
	
	
	/**
	 * this method is used to switch window 
	 * @param driver
	 */
	public void switchWindow(WebDriver driver) {
		String parent = driver.getWindowHandle();
		Set<String> child = driver.getWindowHandles();
		for(String b:child)
		{
			driver.switchTo().window(b);
			
		}
		
	}
	
	public void alterSwitchWindow(WebDriver driver,String particalWindowTitle) {
		Set<String> child = driver.getWindowHandles();
		Iterator<String> it=child.iterator();
		while(it.hasNext()) {
			String parent = it.next();
			String title = driver.switchTo().window(parent).getTitle();
			if(title.contains(particalWindowTitle))
			{
				break;
			}
		}
	}
		
	/**
	 * this method is used to take screenshot
	 * @param driver
	 * @param testCaseName
	 * @return
	 */
	public String screenshot(WebDriver driver,String testCaseName) {
		
		JavaUtility jUtil= new JavaUtility();
		String path ="./photo"+testCaseName+jUtil.getSystemDateAndTime()+".png";
		TakesScreenshot ts= (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File desc = new File(path);
		src.renameTo(desc);
		return path;
	}
	
	/**
	 * this method is used to switch frame 
	 * @param driver
	 * @param index
	 */
	public void switchFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index) ;
	}
	
	/**
	 * this method is used to switch frame 
	 * @param driver
	 * @param nameOrId
	 */
	
	public void switchFrame(WebDriver driver, String nameOrId) {
		driver.switchTo().frame(nameOrId) ;
	}
	
	/**
	 * this method is used to handle alert by accept
	 * @param driver
	 */
	
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept(); ;
	}
	
	/**
	 *  this method is used to handle alert by dismiss
	 * @param driver
	 */
	
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss(); ;
	}
}
