package restAPI;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequestWithParams {

	
	
	    @Test
	    public void test1() {
		
		
		RestAssured.baseURI= "http://localhost:3000/employees";
         
		RequestSpecification request= RestAssured.given();
		
		Response response=request.param("id", "1").get();
		
		String responsebody =response.getBody().asString();
		
		System.out.println( responsebody);
		
		int actcode=200;
		int expcode=response.getStatusCode();
		
		Assert.assertEquals(actcode, expcode);
		
		Assert.assertTrue(responsebody.contains("Pankaj"));
		
		JsonPath jsonp = response.jsonPath();
		
		List<String> name=jsonp.get("name");
		
		System.out.println(name.get(0));
		
		
		Assert.assertEquals(name.get(0), "Pankaj");
		
		String header = response.getHeader("Content-Type");	
		
		System.out.println(header);
		
		
		
		
	}
	
	
	
	
}
