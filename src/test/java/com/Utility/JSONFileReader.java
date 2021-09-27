package com.Utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;


public class JSONFileReader {
	
	
	public static String  readJSONFile_ArrayData(String JSONToPass) throws FileNotFoundException {
		String baseFilePath = System.getProperty("user.dir") +  "\\src\\test\\java\\com\\" ;
		
		File file = new File(baseFilePath + JSONToPass );
		
		FileReader FR = new FileReader(file);
		
		JSONTokener JT = new JSONTokener(FR);
		
		JSONArray JA = new JSONArray(JT);
		
		return JA.toString();
		
		
		
	}
	
	
	
	
	public static String  readJSONFile_ObjectData(String JSONToPass) throws FileNotFoundException {
		String baseFilePath = System.getProperty("user.dir") +  "\\src\\test\\java\\com\\" ;
		
		File file = new File(baseFilePath +JSONToPass);
		
		FileReader FR = new FileReader(file);
		
		JSONTokener JT = new JSONTokener(FR);
		
		JSONObject JO = new JSONObject(JT);
		
		return JO.toString();
		
	}
	
	
	
	

}
