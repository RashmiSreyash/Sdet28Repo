package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertions
{
	@Test
	public void demo()
	{
		System.out.println("launch the browser");
		System.out.println("login to application");
		System.out.println("create organization");
		
		String expectedName="Rashmi";
		String actualName="RashmiSreyash";
		Assert.assertEquals(expectedName, actualName);
		
		System.out.println("logout from application");
		System.out.println("quit the browser");
	}

}
