package RestAssured_Automation.RestAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
//import io.restassured.http.ContentType;

public class NewTest {
  @Test
  public void f() {
	  
	 /* RestAssured.baseURI="https://samples.openweathermap.org";

	  given().
	       param("id","2172797").
	       param("appid","b6907d289e10d714a6e88b30761fae22").
	       when().
	        get("data/2.5/weather").
	        then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().body("base",equalTo("stations"));
	        //body("0.type".equals("m"))
*/	  System.out.println("pass1");
  }
}
