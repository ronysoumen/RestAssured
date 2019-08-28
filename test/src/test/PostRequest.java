package test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PostRequest {

	public static void main(String[] args) {
		/*
		 * Task:Validate post request End points:https://reqres.in/api/register
		 * Request body:{ "email": "eve.holt@reqres.in", "password": "pistol" }
		 * Contentype:JSON NO Headers are needed VALIDATE:id is eqaual to 4 in
		 * the response body extract the body and also extract the token name
		 * and print in the console
		 */
		RestAssured.baseURI = "https://reqres.in";
		// extract the body and store into a variable response type
		Response st = given()
				.body("{\n" + " \"email\": \"eve.holt@reqres.in\",\n" + " \"password\": \"pistol\"\n" + "}")
				.contentType(ContentType.JSON).

				when().post("/api/register").then().assertThat().statusCode(200).and().contentType(ContentType.JSON)
				.and().body("id", equalTo(4)).extract().response();
		// convert response type (that is in raw form in default) to string
		String s = st.asString();
		// we need to convert it ino JSON so that we can traverse through JSON to
		// get the Token and print
		JsonPath js1 = new JsonPath(s);
		// get the value of token
		String tokenvalue = js1.get("token");
		System.out.println(tokenvalue);
		System.out.println(s);

	}

}
