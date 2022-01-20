package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SaveForDuplicatePage 
{
	//initialization of element
	public SaveForDuplicatePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//declaration of element
	@FindBy(name = "button")
	private WebElement saveButton;
	
	@FindBy(xpath = "//input[@class='crmButton small save']")
	private WebElement saveButtonforedit;
	
	@FindBy(linkText = "Contacts")
	private WebElement clickoncontact;
	
	
    //getter method
	public WebElement getSaveButton() {
		return saveButton;
	}
	


	public WebElement getSaveButtonforedit() {
		return saveButtonforedit;
	}


	public WebElement getClickoncontact() {
		return clickoncontact;
	}


	//business logic
	public void clickonSave()
	{
		saveButton.click();
	}
	
	public void clickonsaveforedit()
	{
		saveButtonforedit.click();
	}
	public void clickoncontact2()
	{
		clickoncontact.click();
	}
	

}
