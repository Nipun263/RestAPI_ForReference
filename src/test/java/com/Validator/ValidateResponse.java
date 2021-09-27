package com.Validator;

import org.testng.Assert;

import io.restassured.response.Response;

public class ValidateResponse {
	
	
	public static void verifyStatusCode(Response Res , int ExpectedStatusCode) {
		
		int actualStatusCode = Res.getStatusCode();
		
		Assert.assertEquals(actualStatusCode, ExpectedStatusCode);
		
	}

}
