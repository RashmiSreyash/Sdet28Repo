package com.crm.comcast.genricUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryimplimentationsClass implements IRetryAnalyzer
{

	int count = 0;
	int retryLimit=5;
	public boolean retry(ITestResult result) 
	{
		if(count<retryLimit)
		{
			count++;
			return true;
		}
		
		return false;
	}
	

}
