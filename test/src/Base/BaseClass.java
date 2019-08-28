package Base;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import Resuablecomponents.Postreq;
import Resuablecomponents.Utilites;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BaseClass {

	public static Properties pro;

	public BaseClass() throws IOException {
		FileInputStream file = new FileInputStream(
				"D:\\eclipseproject\\test\\src\\Resuablecomponents\\application.properties");

		pro = new Properties();
		pro.load(file);
		System.out.println(pro.get("host"));

	}

	public static String authorization() {

		RestAssured.baseURI = pro.getProperty("host");
		Response res = given().body(Postreq.getLoginBody()).header("Content-Type", "application/json").when()
				.post(Postreq.getloginResource()).then().extract().response();
		return Utilites.jsonConverter(res).get("session.value").toString();

	}

}
