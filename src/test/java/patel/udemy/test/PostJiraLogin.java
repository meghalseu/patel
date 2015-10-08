package patel.udemy.test;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static com.jayway.restassured.module.jsv.JsonSchemaValidator.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import patel.udemy.model.JiraLoginPostMethods;

import com.fasterxml.jackson.databind.jsonschema.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.jayway.restassured.http.ContentType;

public class PostJiraLogin extends TestCaseBase {

	@Test
	public void validLogin() {

		JiraLoginPostMethods jiralogin = new JiraLoginPostMethods(
				"mpatelmnl@gmail.com", "P@ssw0rd");

		List cookielist = given().contentType(ContentType.JSON).body(jiralogin)
				.when().post("/rest/auth/1/session").then().statusCode(200)
				.body("session.name", is("JSESSIONID")).extract().headers()
				.getList("Set-Cookie");

		System.out.println(cookielist.get(0));

		System.out.println(cookielist.get(1));

	}
	
	@Test
	public void testsampleforschema(){
		
		//get("/rest/auth/1/session").then().assertThat().body(matchesJsonSchemaInClasspath("products-schema.json"));
		//expect().
		
		JiraLoginPostMethods jiralogin = new JiraLoginPostMethods(
				"mpatelmnl@gmail.com", "P@ssw0rd");
		given()
			.contentType(ContentType.JSON)
			.body(jiralogin)
		.when()
			.post("/rest/auth/1/session")
		.then()
			.body(hasItems
					("name", 
					"session.value", 
					"loginInfo.failedLoginCount", 
					"loginInfo.loginCount", 
					"loginInfo.lastFailedLoginTime", 
					"loginInfo.previousLoginTime"));
	}
}