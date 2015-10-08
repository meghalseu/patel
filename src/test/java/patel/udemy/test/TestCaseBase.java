package patel.udemy.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.jayway.restassured.RestAssured;

public abstract class TestCaseBase {
	
	
	@BeforeMethod
	public void beforeMethod() {
		
	//Log.info("Inside Test Setup");

	RestAssured.baseURI = "http://localhost:8080";

	}

	@AfterMethod
	public void afterMethod() {
		
	//Log.info("Inside Test Setup");

	}


}
