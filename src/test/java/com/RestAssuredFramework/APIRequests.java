package com.RestAssuredFramework;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class APIRequests {
	
	static APIVerifications apiVerifications = new APIVerifications();

public static void main(String[] args) 
{
	RestAssured.baseURI = "https://jsonplaceholder.typicode.com/users";
	String response = RestAssured.given().when().get().then().assertThat().log().all().statusCode(200).contentType("application/json; charset=utf-8").extract().response().asString();
	System.out.print(response);
	JsonPath js = apiVerifications.ParseJson(response);
	apiVerifications.VerifyResponseBody(js, 10);	
}
}
