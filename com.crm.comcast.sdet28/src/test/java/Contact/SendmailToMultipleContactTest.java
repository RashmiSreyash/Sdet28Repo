package Contact;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.comcast.genricUtility.FileUtility;
import com.crm.comcast.genricUtility.IPathConstants;

public class SendmailToMultipleContactTest {

	public static void main(String[] args) throws Throwable 
	{
		FileUtility fileUtility = new FileUtility();
		String url = fileUtility.getPropertyFileData("url");
		String browser = fileUtility.getPropertyFileData("browser");
		String username = fileUtility.getPropertyFileData("username");
		String password = fileUtility.getPropertyFileData("password");
		
		System.setProperty(IPathConstants.CHROME_KEY, IPathConstants.CHROME_PATH);
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.id("4")).click();
		driver.findElement(By.id("5")).click();
		driver.findElement(By.id("6")).click();
		
		driver.findElement(By.xpath(" (//input[@value='Send Mail'])[1]")).click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		String parent = driver.getWindowHandle();
		
		
	}

}
