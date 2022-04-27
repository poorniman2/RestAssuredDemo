package restAssuredDemo;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class putRequest {
	@Test
	public void test_post()
	{
		
		baseURI="http://localhost:3000/";
		JSONObject request=new JSONObject();
		request.put("lastName", "shepherd");
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON).header("Conent-Type","application/json").
		body(request.toJSONString()).
		when().patch("/users/4").then().
		statusCode(200).log().all();
		
		
				
	}
}
