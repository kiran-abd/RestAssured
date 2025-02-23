package restAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteRequest {

	@Test
	public void test1() {
		
		
		RestAssured.baseURI="http://localhost:3000/employees";
		RequestSpecification request=RestAssured.given();
		
		Response response=request.delete("/21");
		
		int actcode=response.getStatusCode();
		Assert.assertEquals(actcode, 200);
		
		
		
	}
	
	
}
