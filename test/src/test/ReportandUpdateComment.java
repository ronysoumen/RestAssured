package test;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.annotations.Test;

import Base.BaseClass;
import Resuablecomponents.Postreq;
import Resuablecomponents.Putreqest;
import Resuablecomponents.Utilites;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ReportandUpdateComment extends BaseClass{
	
	
	
  public ReportandUpdateComment() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

@Test
  public void reportComment() {
	RestAssured.baseURI=pro.getProperty("host");
	Response res = given().body(Postreq.getReportComment()).header("Accept","application/json").header("Content-Type","application/json").
	  header("Cookie","JSESSIONID="+ authorization() ).when().post("/rest/api/2/issue/QAR-3/comment").then().statusCode(201).extract().response();
	  
	 
	  JsonPath js = Utilites.jsonConverter(res);
	  String s=js.get("id");
	  System.out.println(s);
	
	
  }
@Test
public void updateComment(){
	RestAssured.baseURI=pro.getProperty("host");
	Response res = given().body(Putreqest.getUpdateComment()).header("Accept","application/json").header("Content-Type","application/json").
	  header("Cookie","JSESSIONID="+ authorization() ).when().put("/rest/api/2/issue/QAR-3/comment/"+Utilites.commentId()).then().statusCode(200).extract().response();
	  
	 
	  JsonPath js = Utilites.jsonConverter(res);
	  String s=js.get("id");
	  System.out.println(s);
	
	
}
}

