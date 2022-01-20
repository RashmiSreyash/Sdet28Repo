package com.crm.comcast.genricUtility;

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

public class WebDriverUtility 
{
	
	/**
	 * it will wait for 20sec till the element load in DOM
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver) 
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	
	/**
	 * this method will wait till element is visible
	 * @param driver
	 * @param element
	 */
	public void waitForVisiblityofElement(WebDriver driver, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	/**
	 * This method will wait till element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClick(WebDriver driver, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
	
	/**
	 * This method is used to wait for the element and do click operation
	 * @param element
	 * @throws Throwable
	 */
	public void waitAndClick(WebElement element) throws Throwable
	{
		int count=0;
		while(count<50) {
			try {
				element.click();
			    }
				
			catch ( Throwable e) {
				Thread.sleep(1000);
				count++;
			}
		}
	}
	
	/**
	 * This method will select the element based on index
	 * @param element
	 * @param index
	 */
	public void selectOption(WebElement element, int index)
	{
		Select select= new Select(element);
		select.selectByIndex(index);
		
	}
	
	/**
	 * This method will select the element based on value
	 * @param element
	 * @param value
	 */
	public void selectOption(WebElement element, String value)
	{
		Select select=new Select(element);
		select.selectByValue(value);
	}
	
	/**
	 * This method is used to select the value based on the text
	 * @param element
	 * @param text
	 */
	public void selectOPtion(WebElement element, String text)
	{
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}
	
	
	/**
	 * this method will verify whether excepted option is present in fdropdown or not
	 * @param element
	 * @param exceptedOptions
	 * @return
	 */
	public WebElement verifyTheDropDownList(WebElement element, String exceptedOptions)
	{
		Select select=new Select(element);
		List<WebElement> options=select.getOptions();
		for(WebElement ele:options)
		{
			if(ele.equals(exceptedOptions))
			{
				System.out.println("value is present in dropdown");
			}
			else
			{
				System.out.println("value is not present in dropdown");
				return ele;
			}
		}
		return null;
	}
	
	/**
	 * This method perform mouse hovering action
	 * @param driver
	 * @param element
	 */
	public void mouseOver(WebDriver driver, WebElement element)
	{
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	
	/**
	 * This method perform right click action
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver, WebElement element)
	{
		Actions action=new Actions(driver);
		action.contextClick(element).perform();
		
	}
	
	/**
	 * Used to perform javascript click on webElement
	 * @param driver
	 * @param element
	 */
	public void jsClick(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click", element);
	}
	
	/**
	 * This Method is used to send the value using javascript executer
	 * @param driver
	 * @param valueToEnter
	 * @param element
	 */
	public void enterDataUsingJs(WebDriver driver, String valueToEnter, WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("argument[0].value="+valueToEnter+"", element);
		
	}
	
	/**
	 * This method will switch to different windows using partial title
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void switchWindow(WebDriver driver, String partialWindowTitle)
	{
		Set<String> winIds=driver.getWindowHandles();
		Iterator<String> it=winIds.iterator();
		while(it.hasNext())
		{
			String winId=it.next();
			String title=driver.switchTo().window(winId).getTitle();
			if(title.contains(partialWindowTitle))
			{
				break;
			}
		}
	
		
	}
	
	/**
	 * Method is used to take screenshot in the case of failures
	 * @param driver
	 * @param testCaseName
	 * @return
	 */
	public String screenShot(WebDriver driver, String testCaseName)
	{
		JavaUtility jUtil=new JavaUtility();
		String filePath="./errorshot/"+testCaseName+jUtil.systemDateAndTime();
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File destination=new File(filePath);
		//files.copy(Source,destination);
		source.renameTo(destination);
		return filePath;
		
	}
	
	
	/**
	 * This method will switch the frames based on the passed 
	 * @param driver
	 * @param index
	 */
	public void switchFrames(WebDriver driver, int index)
	   {
		driver.switchTo().frame(index);
		}
	
	/**
	 * This method will switch the frames based on the name or ID passed
	 * @param driver
	 * @param nameorId
	 */
	public void switchFrames(WebDriver driver, String nameorId)
	{
		driver.switchTo().frame(nameorId);
	}
	
	
	/**
	 * This method will switch the frames based on the webelement passed
	 * @param driver
	 * @param element
	 */
	public void switchFrames(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	
	
	/**
	 * method will accept the alert
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * this method is click on dismiss button in alert popup
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
		
	}

