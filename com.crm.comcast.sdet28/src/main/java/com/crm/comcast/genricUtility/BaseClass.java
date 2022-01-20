package com.crm.comcast.genricUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.comcast.objectRepository.HomePage;
import com.crm.comcast.objectRepository.LoginPage;

public class BaseClass 
{
	public WebDriver driver;
	public static WebDriver sdriver;
	public FileUtility fUtil=new FileUtility();
	public WebDriverUtility wUtil=new WebDriverUtility();
	
	@BeforeSuite(groups= {"smokeTest", "regressionTest"})
	public void configBs()
	{
		//connect to database
		System.out.println("=======connect yo db========");
	}
	//@Parameters("browser")
	@BeforeClass(groups= {"smokeTest", "regressionTest"})
	public void configBc() throws Throwable
	{
		//launching the browser
		String browser = fUtil.getPropertyFileData("browser");
		String url = fUtil.getPropertyFileData("url");
		if(browser.equals("chrome")) {
			System.setProperty(IPathConstants.CHROME_KEY, IPathConstants.CHROME_PATH);
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			System.setProperty(IPathConstants.FIREFOX_KEY, IPathConstants.FIREFOX_PATH);
			driver=new FirefoxDriver();
		}
			else {
				System.out.println("browser not available");
			}
		sdriver=driver;
		driver.manage().window().maximize();
		wUtil.waitForPageLoad(driver);
		driver.get(url);
		
	}
	

	@BeforeMethod (groups= {"smokeTest", "regressionTest"})
	public void configBm() throws Throwable
	{
		//getting the data from property file
		String username = fUtil.getPropertyFileData("username");
		String password = fUtil.getPropertyFileData("password");
		LoginPage login=new LoginPage(driver);
		login.loginToApplication(username, password);
		
	}
	@AfterMethod (groups= {"smokeTest", "regressionTest"})
	public void configAm()
	{
		HomePage homepage=new HomePage(driver);
		homepage.logout();
	}
	@AfterClass (groups= {"smokeTest", "regressionTest"})
	public void configAc()
	{
		//closing the browser
		driver.quit();
	}
	@AfterSuite (groups= {"smokeTest", "regressionTest"})
	public void configAs()
	{
		//closing the database connection
		System.out.println("====database connection is closed");
		
	}
}
