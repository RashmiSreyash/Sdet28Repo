package Contact;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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
public class EditContactTest extends BaseClass
{
	@Test (groups= {"smokeTest"})
	public void editcontact() throws Throwable
	{
		//create the object for FileUtility and ExcelUtility
				FileUtility fUtil=new FileUtility();
				ExcelUtility eUtil=new ExcelUtility();
				WebDriverUtility webUtil=new WebDriverUtility();
				
				
			    
			    //using eUtil refernce we get the data from ecxel sheet
			    String expectedText=eUtil.getStringCellData(IPathConstants.SHEET_NAME, 7, 3);
			    
			   
			    //performing the scenario
				HomePage homepage=new HomePage(driver);
				homepage.clickOnContact();
			    
				//click on rashmi
				ContactPage contactpage=new ContactPage(driver);
				contactpage.clickonRashmi();
				
				
				//click on edit button
				ContactInformationPage contInformation=new ContactInformationPage(driver);
				contInformation.clickonEdit();
				
				//click on save button
				SaveForDuplicatePage saveduplicate=new SaveForDuplicatePage(driver);
				saveduplicate.clickonsaveforedit();
				homepage.clickOnContact();
				
				
				Thread.sleep(5000);
				
				
				//get the title from application
				String actualtext = driver.getTitle();
				System.out.println(actualtext);
				
				//verifying the application
				Assert.assertEquals(expectedText, actualtext);
				
				
				
			    
		
	}

}
