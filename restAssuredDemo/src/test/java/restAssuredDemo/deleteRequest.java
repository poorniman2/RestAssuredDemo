package restAssuredDemo;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
public class deleteRequest {

	@Test
	public void test_delete()
	{
		
		baseURI="http://localhost:3000/";
		when().delete("/users/4").then().statusCode(200).log().all();
		
		
				
	}
	
}
