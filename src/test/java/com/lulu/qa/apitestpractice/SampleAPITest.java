package com.lulu.qa.apitestpractice;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;




public class SampleAPITest {

	@Test
	public static void getRequest() {
		String response = given().when().get("https://reqres.in/api/users?page=2").asString();
		
		System.out.println(response);
	}
	
	@Test
	public static void getRequestForSingleUser() {
		Response response = given().when().get("https://reqres.in/api/users?id=743");
		String listUsers = response.getBody().asString();
		System.out.println(listUsers);
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		assertEquals(200,response.getStatusCode());
	}
	@Test
	public static void postRequestAddSingleUser() {
		RestAssured.baseURI = "https://reqres.in/api/users";
		
		String requestBody = "{\r\n" + 
				"    \"name\": \"manikant1\",\r\n" + 
				"    \"job\": \"leader\"\r\n" + 
				"}";
		
		Response response = null;
		 
        try {
            response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post("/");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println("Response :" + response.asString());
        System.out.println("Status Code :" + response.getStatusCode());
        response.prettyPrint();
	}
}

