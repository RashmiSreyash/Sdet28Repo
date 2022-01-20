package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrganizationTest {

	public static void main(String[] args) throws IOException, Throwable
	{
		//Java Object representation of physical property file
				FileInputStream fis = new FileInputStream("./src/test/resources/data.properties");
				
				
				//create an object for properties class
				Properties property = new Properties();
				
				//load the key and values from property object
				property.load(fis);
				
				//fetch the value using respective keys
				String browser = property.getProperty("browser");
				String url = property.getProperty("url");
				String username = property.getProperty("username");
				String password = property.getProperty("password");
				
				System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
				WebDriver driver=new ChromeDriver();
				
				driver.manage().window().maximize();
				driver.get(url);
				
				driver.findElement(By.name("user_name")).sendKeys(username);
				driver.findElement(By.name("user_password")).sendKeys(password);
				driver.findElement(By.id("submitButton")).click();
				
				driver.findElement(By.linkText("Organizations")).click();
				driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
				
				driver.findElement(By.name("accountname")).sendKeys("TY3 software");
				driver.findElement(By.name("button")).click();
				
				driver.switchTo().alert().accept();
				
				WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				Actions action=new Actions(driver);
				action.moveToElement(ele).perform();
				
				
				Thread.sleep(3000);
				
				driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
				

	}

}
