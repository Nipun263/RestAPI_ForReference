package com.TestCases;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import com.TestSuite.HttpMethods;
import com.Utility.JSONFileReader;
import com.Utility.PropertyFileReader;
import com.Validator.ValidateResponse;
import io.restassured.module.jsv.JsonSchemaValidator.*;
import io.restassured.response.Response;

public class TestCase_AllRequests {
	
	
	@Test(priority=1)
	public void postRequest_TestCase() throws IOException {
		Properties PRP = PropertyFileReader.readPropertyFile("//URI.Properties" );
		
		HttpMethods HTM = new HttpMethods(PRP); 
		
		String jsonFileToPass = JSONFileReader.readJSONFile_ArrayData("//Resources" + "//PostRequest.JSON");
		
		String jsonSchemaDataToValidate = JSONFileReader.readJSONFile_ObjectData("//Schema" + "//JSONArray_PostReq_Schema.JSON");
		
		Response Res = 	HTM.postRequest(jsonFileToPass, "QA_URI" , jsonSchemaDataToValidate );
		

		
		ValidateResponse.verifyStatusCode(Res, 201);
		
	}

	@Test(priority=2)
	public void getRequest_TestCase() throws IOException {
		
		Properties PRP = PropertyFileReader.readPropertyFile("//URI.Properties");
		
		HttpMethods HTM = new HttpMethods(PRP);
		
		String ExpectedSchema = JSONFileReader.readJSONFile_ObjectData("//Schema" + "//JSONSchema_GetRequest.JSON");
		
		Response Res =  HTM.getRequest("QA_URI" , ExpectedSchema);
		
		ValidateResponse.verifyStatusCode(Res, 200);
		
		
	}
	
	
	//@Test(priority=1)
	public void postRequest_SampleData() throws IOException {
		Properties PRP = PropertyFileReader.readPropertyFile("//URI.Properties");
		
		HttpMethods HTM = new HttpMethods(PRP);
		
		String jsonFileData = JSONFileReader.readJSONFile_ObjectData("//Resources" + "//SampleJSONFile.JSON");
		
		Response Res =  HTM.PostRequestAndJSONParsing(jsonFileData, "Dev_URI");
				
				
	}
	
	@Test(priority=3)
	public void putRequest_TestCase() throws IOException {
		Properties PRP = PropertyFileReader.readPropertyFile("\\URI.Properties");
		
		HttpMethods HTM = new HttpMethods(PRP);
		
		String jsonDataToPass = JSONFileReader.readJSONFile_ArrayData("//Resources" +"//PutRequest.JSON");
		
		String SchemaData = JSONFileReader.readJSONFile_ObjectData("//Schema" +"//PutRequest.JSON");
		
		Response Res = 	HTM.PutRequest(jsonDataToPass, "QA_URI" , "/1" , SchemaData);
		
		ValidateResponse.verifyStatusCode(Res,200);
		
		
	}
	
	@Test(priority=4)
	public void DeleteRequest_TestCase() throws IOException {
		Properties PRP = PropertyFileReader.readPropertyFile("\\URI.Properties");
		
		HttpMethods HTM = new HttpMethods(PRP);
		
		Response Res = 	HTM.DeleteRequest("QA_URI" , "/1");
		
		
	}
	

}
