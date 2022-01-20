package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryClass 
{
	@Test(retryAnalyzer = com.crm.comcast.genricUtility.RetryimplimentationsClass.class)
	public void retry()
	{
		Assert.assertEquals(true, false);
	}

}
