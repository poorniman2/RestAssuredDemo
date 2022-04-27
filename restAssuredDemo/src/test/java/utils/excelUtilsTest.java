package utils;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class excelUtilsTest {
	
	@DataProvider
	public Object[][] getData()
	{
		Object data[][]=TestUtil.testData("Sheet1");
		return data;
		
	}

	
	@Test(dataProvider = "getData")
	public void excelFunc(String fname,String lname,String email,String id)
	{
	System.out.println(fname+" "+lname+" "+email+" "+id);
	baseURI="http://localhost:3000/";
	JSONObject request=new JSONObject();
	request.put("firstName", fname);
	request.put("lastName", lname);
	request.put("email", email);
	request.put("subjectid", id);
	
	given().contentType(ContentType.JSON).accept(ContentType.JSON).header("Conent-Type","application/json").
	body(request.toJSONString()).
	when().post("/users").then().
	statusCode(201).log().all();
	}
}
