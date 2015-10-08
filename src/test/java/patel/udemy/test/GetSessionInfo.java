package patel.udemy.test;


import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.List;
import org.testng.annotations.Test;
import patel.udemy.model.JiraLoginPostMethods;
import com.jayway.restassured.http.ContentType;


public class GetSessionInfo extends TestCaseBase{
	
	@Test	
	public void validLogin(){
				
		JiraLoginPostMethods jiralogin = new JiraLoginPostMethods("mpatelmnl@gmail.com", "P@ssw0rd");
		
		
		List<String> headerlist =	
		given()
			.contentType(ContentType.JSON)
			.body(jiralogin)
		.when()
			.post("/rest/auth/1/session")
		.then()
			.statusCode(200)
			.body("session.name", is("JSESSIONID"))
		.extract()
			.headers()
			.getValues("Set-Cookie");
			
		//System.out.println(headerlist);
		//System.out.println(headerlist.size());
		
		
		 String cookie1 = headerlist.get(0);
		 String cookie2 = headerlist.get(1);
		 
		 String headercookie = cookie1+";"+cookie2;
		 
		 //System.out.println("Cookie1: " +cookie1);
		 //System.out.println("Cookie1: " +cookie2);
		 
		 System.out.println(headercookie);
		
		 System.out.println(
		given()
			.header("Cookie", headercookie)
		.when()
			.get("/rest/auth/1/session")
		.then()
			.statusCode(200)
			.body("name", is(jiralogin.getUsername()))
		.extract()
			//.path("loginInfo.loginCount")
		.response().getBody().asString());
		
			
	}
	
}
	


