package Contact;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.SendKeysAction;

import com.crm.comcast.genricUtility.FileUtility;
import com.crm.comcast.genricUtility.IPathConstants;

public class SendmailTo1ContactTest {

	public static void main(String[] args) throws Throwable 
	{
		FileUtility fileUtility = new FileUtility();
		String browser = fileUtility.getPropertyFileData("browser");
		String url = fileUtility.getPropertyFileData("url");
		String username = fileUtility.getPropertyFileData("username");
		String password = fileUtility.getPropertyFileData("password");
		
		System.setProperty(IPathConstants.CHROME_KEY, IPathConstants.CHROME_PATH);
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
	
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Rashmi")).click();
		driver.findElement(By.xpath("(//a[@class='webMnu'])[1]")).click();
		driver.findElement(By.name("Select")).click();
		Thread.sleep(5000);

		
        JavascriptExecutor js=(JavascriptExecutor) driver; 
        js.executeScript("arguments[0].value='Rashmi'", driver.findElement(By.xpath("//b/ancestor::tr/descendant::input[@name='parent_id']")));
       
        
		driver.findElement(By.name("subject")).sendKeys("hello Piyush");
		driver.findElement(By.name("Send")).click();
		
		driver.close();
		
		
		

	}
	

}
