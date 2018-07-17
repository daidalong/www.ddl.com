package com.ddl.core.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {

	private PropertiesUtil() {
	}

	private static Properties prop = new Properties();

	private static void init() {
		try {
			String filePath = PropertiesUtil.class.getResource("/").getPath();
			FileInputStream fis = new FileInputStream(filePath + "system.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static {
		init();
	}

	public static String getProperty(String key) {
		return prop.getProperty(key);
	}

}
