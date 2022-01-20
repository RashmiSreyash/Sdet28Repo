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
import com.crm.comcast.objectRepository.ContactPage;
import com.crm.comcast.objectRepository.HomePage;
import com.crm.comcast.objectRepository.LoginPage;
@Listeners(com.crm.comcast.genricUtility.ListenerImpClass.class)
public class DeleteContactTest extends BaseClass
{
	@Test (groups= {"regressionTest"})
	public void deletecontact() throws Throwable
	{
		//create the object for FileUtility and ExcelUtility
		FileUtility fUtil=new FileUtility();
		ExcelUtility eUtil=new ExcelUtility();
		WebDriverUtility webUtil=new WebDriverUtility();
	    
	    //get the data from excel sheet
	   String expectedText=eUtil.getStringCellData(IPathConstants.SHEET_NAME, 5, 3);
	   
	    
		//click on contact
		HomePage homepage=new HomePage(driver);
		homepage.clickOnContact();
		
		//click on checkbox buttom
		ContactPage contactpage=new ContactPage(driver);
		contactpage.clickonCheckbox();
		
		//delete the contact
		contactpage.deletecontact();
				
	    driver.switchTo().alert().accept();
	    
	   
		Thread.sleep(5000);
		
		
		//get the title from application
		String actualtext = driver.getTitle();
		System.out.println(actualtext);
		
		//verifying the application
		Assert.assertEquals(expectedText, actualtext);
		
		
	    
	    
	}

}
