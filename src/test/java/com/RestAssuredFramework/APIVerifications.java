package com.RestAssuredFramework;

import org.testng.Assert;

import io.restassured.path.json.JsonPath;

public class APIVerifications {
	public void VerifyResponseBody(JsonPath js, int ExpectedValue) {
		int users_count = js.getInt("id.size()");
		System.out.print(users_count);
		Assert.assertEquals(ExpectedValue, users_count);
	}

	public JsonPath ParseJson(String response) {
		JsonPath js = new JsonPath(response);
		return js;
	}
}
