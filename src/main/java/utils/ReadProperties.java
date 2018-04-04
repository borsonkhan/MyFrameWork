package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadProperties {

	public static void main(String args[]) {
		System.out.println(loadPropertes("QA"));

	}

	public static Properties loadPropertes(String properFileName) {
		Properties properFile = new Properties();

		String filePath = ".\\src\\main\\java\\resources\\properties\\" + properFileName.trim() + ".properties";

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
