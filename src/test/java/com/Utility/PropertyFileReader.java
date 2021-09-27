package com.Utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {
	
	
	
	
	public static  Properties readPropertyFile(String PropertyFilePath) throws IOException {
		
		String baseFilePath = System.getProperty("user.dir")+ PropertyFilePath ;
		
		File file = new File(baseFilePath);
		
		FileReader FR = new FileReader(file);
		
		Properties PRP = new Properties();
		
		PRP.load(FR);
		
		return PRP ;
	}
	
	
}
