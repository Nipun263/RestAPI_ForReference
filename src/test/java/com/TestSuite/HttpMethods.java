package com.TestSuite;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class HttpMethods {
	
	Properties PRP ;
	
	public HttpMethods(Properties PRP){
		this.PRP=PRP;
	}
	
	
	public Response postRequest(String bodyData , String URI_Key , String ExpectedScheme) {
		Response Res = given().contentType(ContentType.JSON).body(bodyData).when().post(PRP.getProperty(URI_Key));
		
		
		System.out.println("***********Post Request Response is : + ***************");
		System.out.println(Res.asPrettyString());
		
		
		System.out.println("***********Post Request Status Code is : + ***************");
		System.out.println(Res.statusCode());
		
		System.out.println("**********Headers are :: ***************");
		System.out.println(Res.headers());
		
		Res.then().assertThat().body(matchesJsonSchema(ExpectedScheme));
		
		return Res;
		
	}
	
	
	public Response getRequest(String URI_Key , String ExpectedSchema) {
		Response Res = given().contentType(ContentType.JSON).auth().none().when().get(PRP.getProperty(URI_Key));
		
		System.out.println("***********Get Request Response is : + ***************");
		System.out.println(Res.asPrettyString());
		
		
		System.out.println("***********Get Request Status Code is : + ***************");
		System.out.println(Res.statusCode());
		
		System.out.println("**********Headers are :: ***************");
		System.out.println(Res.headers());
		
		Res.then().assertThat().body(matchesJsonSchema(ExpectedSchema));
		
		return Res ;
		
		
	}
	
	
	public Response PostRequestAndJSONParsing(String bodyData , String URI_KEY) {
		Response Res = given().contentType(ContentType.JSON).body(bodyData).auth().none().when().post(PRP.getProperty(URI_KEY));
		//System.out.println(Res.asPrettyString());
		
		
		
		  JSONTokener JT = new JSONTokener(Res.asPrettyString());
		  
		  JSONObject JO = new JSONObject(JT); // System.out.println(JO);
		  
		  
		  JSONArray arrayData = JO.getJSONArray("data"); System.out.println(arrayData);
		  
		  int size = arrayData.length(); for(int i = 0 ; i < arrayData.length() ; i ++)
		  { JSONObject innerObj1 =
		  arrayData.getJSONObject(i).getJSONObject("relationships");
		  
		  JSONObject innerObj2 = innerObj1.getJSONObject("author");
		  
		  JSONObject innerObj3 = innerObj2.getJSONObject("data");
		  
		  String Id_Value_Extracted = innerObj3.getString("type");
		  System.out.println(Id_Value_Extracted); }
		 
		
		//Using JSONPath 
		
		System.out.println(Res.asPrettyString());
		
		String Id_Extracted = Res.jsonPath().getString("data[0].relationships.author.data.id");
		System.out.println(Id_Extracted);
		
		return Res;
	}
	

	
	
	public Response PutRequest(String bodyData , String URI_KEY , String QueryParameter  , String schemaData) {
		Response Res = given().contentType(ContentType.JSON).body(bodyData).when().put(PRP.getProperty(URI_KEY) + QueryParameter);
		
		System.out.println("***********Put Request Status Code is : + ***************");
		System.out.println(Res.statusCode());
		System.out.println();
		System.out.println("***********Put Request Response is : + ***************");
		System.out.println(Res.asPrettyString());
		
		
		Res.then().assertThat().body(matchesJsonSchema(schemaData));
		
		return Res ;
	}
	
	

	public Response DeleteRequest(String URI_KEY , String QueryParameter) {
		Response Res = given().contentType(ContentType.JSON).when().delete(PRP.getProperty(URI_KEY) + QueryParameter);
		
		System.out.println("***********Delete Request Status Code is : + ***************");
		System.out.println(Res.statusCode());
		System.out.println();
		System.out.println("***********Delete Request Response is : + ***************");
		System.out.println(Res.asPrettyString());
		
		
		return Res;
	}
	
	
}


