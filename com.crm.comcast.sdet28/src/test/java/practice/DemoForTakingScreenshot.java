package practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.genricUtility.BaseClass;
@Listeners(com.crm.comcast.genricUtility.ListenerImpClass.class)
public class DemoForTakingScreenshot extends BaseClass
{
	@Test
	public void sample() {
		String expectedName="Rashmi";
		String actualNam="RashmiSreyash";
		Assert.assertEquals(actualNam, expectedName);
	}

}
