package Contact;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.genricUtility.BaseClass;
import com.crm.comcast.genricUtility.ExcelUtility;
import com.crm.comcast.genricUtility.FileUtility;
import com.crm.comcast.genricUtility.IPathConstants;
import com.crm.comcast.genricUtility.WebDriverUtility;
import com.crm.comcast.objectRepository.ContactInformationPage;
import com.crm.comcast.objectRepository.ContactPage;
import com.crm.comcast.objectRepository.HomePage;
import com.crm.comcast.objectRepository.LoginPage;
import com.crm.comcast.objectRepository.SaveForDuplicatePage;
@Listeners(com.crm.comcast.genricUtility.ListenerImpClass.class)
public class CheckDuplicatesTest  extends BaseClass{

	@Test(groups= {"regressionTest"})
	public void checkduplicate() throws Throwable
	{
		
		//creating object for Utility class
		FileUtility fileUtility = new FileUtility();
		ExcelUtility eUtil = new ExcelUtility();
		WebDriverUtility webUtility=new WebDriverUtility();
		
				
	    //get the data from excel sheet
	    String exceptedText = eUtil.getStringCellData(IPathConstants.SHEET_NAME, 1,3);
	   
		
	   
		//click on contact
		HomePage homepage=new HomePage(driver);
		homepage.clickOnContact();
		
		//click on 1contact
		ContactPage contactpage=new ContactPage(driver);
		contactpage.clickonRashmi();
		
		//click on duplicate
		ContactInformationPage contInformation=new ContactInformationPage(driver);
		contInformation.clickOnDuplicate();
		
		//click on save
		
		SaveForDuplicatePage saveduplicate=new SaveForDuplicatePage(driver);
		saveduplicate.clickonSave();
		
		
		//verified the test script
		String actualtext = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(actualtext.contains(exceptedText))
		{
			System.out.println("duplicate is verified");
		}
		else
		{
			System.out.println("duplicate is not verified");
		}
		
		
	}

}
