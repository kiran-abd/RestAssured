package restAPI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestWithFile {
	
	
	@Test
	public void test1() throws IOException {
		
		
		RestAssured.baseURI="http://localhost:3000/employees";
		
		byte[] dataBytes = Files.readAllBytes(Paths.get("Data.Json"));


		
		RequestSpecification request=RestAssured.given();
		Response response=request.contentType(ContentType.JSON).
		accept(ContentType.JSON)
		.body(dataBytes)
		.post("/create");
		
		String responsebody=response.body().asString();
		
		System.out.println(responsebody);
		
		int expcode=response.getStatusCode();
		
		Assert.assertEquals(expcode, 201);
		
		
		
		
		JsonPath jobj=response.jsonPath();
		
		String name =jobj.get("name");
		System.out.println(name);
		
		int id =jobj.get("id");
		System.out.println(id);
		
		String salary = jobj.get("salary");
		System.out.println(salary);
		
		
		
		
		
		
		
		
		
	}

}
