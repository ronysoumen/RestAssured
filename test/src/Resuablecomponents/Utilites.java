package Resuablecomponents;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;
import com.sun.tools.xjc.model.SymbolSpace;

import Base.BaseClass;



public class Utilites extends BaseClass {
	public Utilites() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public static  JsonPath jsonConverter(Response res){
		
		String s=res.asString();
		JsonPath js=new JsonPath(s);
		return js;
		
	}
	
	public static String commentId(){
		 RestAssured.baseURI=pro.getProperty("host");
			Response res = given().body(Postreq.getReportComment()).header("Accept","application/json").header("Content-Type","application/json").
			  header("Cookie","JSESSIONID="+ authorization() ).when().post("/rest/api/2/issue/QAR-3/comment").then().statusCode(201).extract().response();
			  
			 
			  JsonPath js = Utilites.jsonConverter(res);
			  String s=js.get("id");
			  System.out.println(s);
			  return s;
	}
	/*public static String getauthenticationkey(){
		try{
     loadProparty();
		}
		catch(IOException e){
			System.out.println();
			
		}
			
		
		RestAssured.baseURI=pro.getProperty("host");
		Response res = given().body(Postreq.getLoginBody()).header("Content-Type","application/json").when().post(Postreq.getloginResource()).then().extract().response();
	      
			
   return jsonConverter(res).get("session.value").toString();
   
		
		
		
		
		
	}
	public static void loadProparty() throws IOException{
		
		FileInputStream file=new FileInputStream("D:\\eclipseproject\\test\\src\\Resuablecomponents\\application.properties");
	
		 pro=new Properties();
		pro.load(file);
		System.out.println(pro.get("host"));
		
	}
	*/
	
	

}
