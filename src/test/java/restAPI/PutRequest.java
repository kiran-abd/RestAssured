package restAPI;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutRequest {
	
	@Test
	public void test1() {
		
		RestAssured.baseURI= "http://localhost:3000/employees"; 
		
		Map<String,Object> mobj = new  HashMap<String,Object>();
		mobj.put("name","Kiran");
		mobj.put("salary", "8000");
		
		
		RequestSpecification request=RestAssured.given();
		Response response=request.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(mobj)
		.put("/21");
		
		
		String responsebody=response.getBody().asString();
		System.out.println(responsebody);
		
		int expcode = response.getStatusCode();
		Assert.assertEquals(expcode, 200);
		
		
		
		
		
		
		
	}

}
