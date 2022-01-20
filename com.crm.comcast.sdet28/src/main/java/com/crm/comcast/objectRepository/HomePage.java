package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genricUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility
{
	//initialization of element
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	//declaration of elements
	@FindBy(linkText = "Contacts")
	private WebElement contactLink;
	
	@FindBy(linkText = "Organizations")
	private WebElement organizationlink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement logoutImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signoutlink;
	
	//getters method
	public WebElement getContactLink() {
		return contactLink;
	}

	public WebElement getOrganizationlink() {
		return organizationlink;
	}

	public WebElement getLogoutImg() {
		return logoutImg;
	}

	public WebElement getSignoutlink() {
		return signoutlink;
	}
	
	//business logics
	/**
	 * this method will click on organization link
	 */
	public void clickOrganizationLink()
	{
		organizationlink.click();
	}
	
	/**
	 * this method will click on contact link
	 */
	public void clickOnContact()
	{
		contactLink.click();
		
	}
	
	public void logout()
	{
		mouseOver(driver, logoutImg);
		signoutlink.click();
	}
	
}
