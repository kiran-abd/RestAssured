package restAPI;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest {

	@Test
	public void test1() {
		
		
		
		RestAssured.baseURI = "http://localhost:3000/employees";
		RequestSpecification request=RestAssured.given();
         Response response= request.get();  
        String responsebody= response.getBody().asString();
        
        System.out.println(responsebody);
        
        int ActCode = 200;
        int ExpCode= response.getStatusCode();
        
        Assert.assertEquals(ActCode, ExpCode);
        
        JsonPath jsonp = response.jsonPath();
        List<String> name =jsonp.get("name");
        
        for(String Name: name) {
        	
        	System.out.println(Name);
        }
        
        
        
		
	}
	
	
}
