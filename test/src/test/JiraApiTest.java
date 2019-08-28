package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseClass;
import Resuablecomponents.Postreq;
import Resuablecomponents.Utilites;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class JiraApiTest extends BaseClass{
	
	public JiraApiTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}



	@BeforeTest
	public void setup() throws IOException{
		
	

	}
	
	
	
  @Test
  public void testCreateIssue() {
	  RestAssured.baseURI=pro.getProperty("host");
	Response res = given().body(Postreq.getCreateIssueBody()).header("Accept","application/json").header("Content-Type","application/json").
	  header("Cookie","JSESSIONID="+ authorization() ).when().post("/rest/api/2/issue").then().statusCode(201).extract().response();
	  
	 
	  JsonPath js = Utilites.jsonConverter(res);
	  String s=js.get("id");
	  System.out.println(s);
	  
	  
  }
}
