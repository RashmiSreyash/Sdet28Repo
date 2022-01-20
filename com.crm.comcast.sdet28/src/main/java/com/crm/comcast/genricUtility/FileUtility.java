package com.crm.comcast.genricUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtility 
{
	/**
	 * This method will fetch the data from property file based on the key passed
	 * @return
	 * @throws Throwable
	 */
	public String getPropertyFileData(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstants.PROPERTY_FILEPATH);
		Properties property = new Properties();
		property.load(fis);
		return property.getProperty(key);
	}

}
