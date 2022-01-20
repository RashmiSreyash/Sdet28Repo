package com.crm.comcast.genricUtility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class ListenerImpClass implements ITestListener {
	
	public void onTestFailure(ITestResult result)
	{
		String testCaseName = result.getMethod().getMethodName();
		System.out.println(testCaseName);
		
		//take screenshot code
		EventFiringWebDriver event = new EventFiringWebDriver(BaseClass.sdriver);
		File source = event.getScreenshotAs(OutputType.FILE);
		File destination = new File("./errorshot/"+ testCaseName +".png");
		
		try {
			FileUtils.copyDirectory(source, destination); //DOUBT
			// source.renameTo(destination);
		    } 
		catch (Exception e) 
		{
			e.printStackTrace();
			
		}
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	

}
