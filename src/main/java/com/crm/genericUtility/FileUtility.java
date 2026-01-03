package com.crm.genericUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	public String readDataFromProperty(String key) throws Exception {
		FileInputStream fis = new FileInputStream("./src/test/resources/commonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(key);

	}
}
