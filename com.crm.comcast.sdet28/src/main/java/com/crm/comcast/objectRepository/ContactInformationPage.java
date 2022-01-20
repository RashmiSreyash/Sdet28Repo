package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage 
{
	//initialization of Element
	public ContactInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declaration of element
	@FindBy(name="Duplicate")
	private WebElement duplicateButton;
	
	@FindBy(name = "Edit")
	private WebElement editbutton;
	

	//getters method
	public WebElement getDuplicateButton() {
		return duplicateButton;
	}
	


	public WebElement getEditbutton() {
		return editbutton;
	}





	//business logic
	public void clickOnDuplicate()
	{
		duplicateButton.click();
	}
	
	public void clickonEdit()
	{
		editbutton.click();
	}
	
	

}
