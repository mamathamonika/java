package com.crm.comcast.GenricUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * 
 * @author Mamatha
 *
 */

public class FileUtility {
	
/**
 * this method fetch the data from property file based on key passed
 * @param key
 * @return
 * @throws Throwable 
 */

	public String getPropertyFileData(String key) throws Throwable
	{
	FileInputStream fis = new FileInputStream(IpathConstant.PROPERTY_FILE_PATHH);
	Properties property = new Properties();
	property.load(fis);
	return property.getProperty(key);
	
}
}
