package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigsReader {
	// the goal of this class is to read a file
	// and we are creating separate methods to read seperate files
	
	
public	static Properties prop;


	/**
	 * This method will read property file
	 * @param FilePath
	 */
	public static void readProperties(String FilePath) { // it will read any values/ properties
		try {
			FileInputStream fis=new FileInputStream(FilePath);
			prop=new Properties();
				prop.load(fis);
				fis.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * this method will return value of specified key
	 * @param String key
	 * @return String
	 */
	public static String getProperty(String key) { // this method will retrieve values, to get url, browser etc. 
		return prop.getProperty(key);
	}
	
	
	
	
	
	
}

