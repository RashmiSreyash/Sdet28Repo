package Contact;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

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
public class PopupalertTest extends BaseClass{

	@Test (groups = {"smokeTest"})
	public void pupupalert() throws Throwable
	{
		//creating object for Utility class
		FileUtility fileUtility = new FileUtility();
		ExcelUtility eUtil = new ExcelUtility();
		WebDriverUtility webUtility=new WebDriverUtility();
		
		
		// using eUtil we get the data from excel sheet
		 String expectedText=eUtil.getStringCellData(IPathConstants.SHEET_NAME, 7, 3);
		
		
		//performing to the application according to the test case
		HomePage homepage=new HomePage(driver);
		homepage.clickOnContact();
	
		//click on send mail
		ContactPage contactpage=new ContactPage(driver);
		contactpage.clickonsend();
		
		homepage.acceptAlert(driver);
		
		Thread.sleep(3000);
	
		
		
        // get the title from application
		String actualtext = driver.getTitle();
		System.out.println(actualtext);
		
		//verifying the application
	    Assert.assertEquals(expectedText, actualtext);
		
		
	
	}
	
	

}
