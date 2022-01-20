package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage 
{
	//initialization of element
	public ContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//declaration of element
	@FindBy(linkText = "Rashmi")
	private WebElement rashminame;
	
	@FindBy(xpath = "(//input[@value='Send Mail'])[1]")
	private WebElement sendmail;
	
	@FindBy(id = "38")
	private WebElement clickCheckbox;
	
	@FindBy(xpath = "(//input[@class='crmbutton small delete'])[1]")
	private WebElement deletebutton;

	//getters method
	public WebElement getRashminame() 
	{
		return rashminame;
	}
	
	public WebElement getSendmail() {
		return sendmail;
	}

	public WebElement getClickCheckbox() {
		return clickCheckbox;
	}
	

	public WebElement getDeletebutton() {
		return deletebutton;
	}

	//business Logic 
	public void clickonRashmi()
	{
		rashminame.click();
	}
	
	public void clickonsend()
	{
		sendmail.click();
	}
	
	public void clickonCheckbox()
	{
		clickCheckbox.click();
	}
	
	public void deletecontact()
	{
		deletebutton.click();
	}

}
