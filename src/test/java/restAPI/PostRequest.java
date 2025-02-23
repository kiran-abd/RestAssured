package restAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequest {
	
	
	@Test
	public void test1() {
		
		RestAssured.baseURI="http://localhost:3000/employees";
		
		RequestSpecification request=RestAssured.given();
		
		Response response=request.contentType(ContentType.JSON).accept(ContentType.JSON)
		.body("  {\r\n"
				+ "    \r\n"
				+ "        \"name\": \"Vestappan\",\r\n"
				+ "        \"salary\": \"12000\"\r\n"
				+ "    }").post("create");
		
		
		String responsebody =response.getBody().asString();
		System.out.println(responsebody);
		
		
		response.getStatusCode();
		
		
	
		Assert.assertEquals(response.getStatusCode(), 201);
		Assert.assertTrue(responsebody.contains("Vestappan"));
		
		
		JsonPath jsonp = response.jsonPath();
		int id= jsonp.get("id");
		
		System.out.println("Assigned ID is "+id);
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
