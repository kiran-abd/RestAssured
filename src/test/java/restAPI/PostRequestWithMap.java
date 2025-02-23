package restAPI;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestWithMap {
	
	@Test
	public void test1() {
		
		RestAssured.baseURI="http://localhost:3000/employees";
		
		Map<String,Object> mapobj = new HashMap<String,Object>();
		mapobj.put("name", "ran");
		mapobj.put("salary", "2900");
		
		
		RequestSpecification request=RestAssured.given();
		Response response= request.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(mapobj)
				.post("create");
		String responsebody=response.getBody().asString();
		System.out.println(responsebody);
		

		int actcode=201;
		
		Assert.assertEquals(response.getStatusCode(), actcode);
		
		JsonPath jpath = response.jsonPath();
		int id=jpath.get("id");
		
		System.out.println(id);
		
		
	}

}
