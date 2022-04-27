package restAssuredDemo;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class dataDrivenDemo extends dataForTests {

	
	/*
	
	@Test(dataProvider = "postRequest")
	public void test_dataDriven(String fName,String lName,String email,int subjectID)
	{
		
		baseURI="http://localhost:3000/";
		JSONObject request=new JSONObject();
		request.put("firstName", fName);
		request.put("lastName", lName);
		request.put("email", email);
		request.put("subjectid", subjectID);
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON).header("Conent-Type","application/json").
		body(request.toJSONString()).
		when().post("/users").then().
		statusCode(201).log().all();
		
		
				
	}*/
	@Test(dataProvider = "deletetRequest")
	public void test_dataDrivenDelete(int id)
	{
		
		baseURI="http://localhost:3000/";
		when().delete("users/"+id).then().statusCode(200);
		
		
				
	}
	@Parameters("userid")
	@Test
	public void test_dataDrivenDelete2(int id)
	{
		System.out.println("userid id is "+id);
		baseURI="http://localhost:3000/";
		when().delete("users/"+id).then().statusCode(200);
		
		
				
	}
}
