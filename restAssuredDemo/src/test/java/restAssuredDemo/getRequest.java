package restAssuredDemo;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class getRequest {

	@Test
	public void test_get()
	{
		baseURI="http://localhost:3000/";
		given()
		.param("name", "Automation").get("/subjects").then().statusCode(200).log().all();
				
	}
	
	
	
}
