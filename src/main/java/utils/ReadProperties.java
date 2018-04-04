package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadProperties {

	public String getProperty(String key) {
		String value = null;

		key = key.trim();
		Properties properFileName = loadPropertes("testRun");

		value = properFileName.getProperty(key);

		if (value == null) {
			String testEnv = properFileName.getProperty("testEnv");

			properFileName = loadPropertes(testEnv);

			value = properFileName.getProperty(key);

		}

		return value;
	}

	public String getSaucelabsProperty(String key) {
		String value = null;

		key = key.trim();
		Properties properFileName = loadPropertes("saucelabs");

		value = properFileName.getProperty(key);

		return value;
	}

	public Properties loadPropertes(String properFileName) {
		Properties properFile = new Properties();

		String filePath = ".\\src\\main\\resources\\properties\\" + properFileName.trim() + ".properties";

		try {
			File file = new File(filePath);
			FileInputStream fileStream = new FileInputStream(file);
			properFile.load(fileStream);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return properFile;
	}
}
