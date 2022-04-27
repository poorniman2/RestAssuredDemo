package restAssuredDemo;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
public class postRequest {

	
	@Test
	public void test_post()
	{
		
		baseURI="http://localhost:3000/";
		JSONObject request=new JSONObject();
		request.put("firstName", "Peter");
		request.put("lastName", "lop");
		request.put("email", "p.l@gmail.com");
		request.put("subjectid", "2");
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON).header("Conent-Type","application/json").
		body(request.toJSONString()).
		when().post("/users").then().
		statusCode(201).log().all();
		
		
				
	}
	
}
