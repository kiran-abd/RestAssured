package apiChaining;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class EndToEndTesting {
	
	Response response;
	String  BaseUri = "http://localhost:3000/employees";
	int Emp_Id;

	@Test
	public void test1() {
		
		response = GetMethodAll();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		
		response = PostMethod("sharu","3000");
		Assert.assertEquals(response.getStatusCode(), 201);
		
		JsonPath jspath =response.jsonPath();
		int Emp_Id=jspath.get("id");
		
		System.out.println(Emp_Id);
		
		response = PutMethod(Emp_Id,"Diya","15000");
		Assert.assertEquals(response.getStatusCode(), 200);
		
		JsonPath jpath =response.jsonPath();
		Assert.assertEquals(jpath.get("name"), "Diya");
		
		
		response=DeleteMethod(Emp_Id);
		Assert.assertEquals(response.getStatusCode(),200);
		
		
		response = GetEmployeeInfo(Emp_Id);
		Assert.assertEquals(response.getStatusCode(), 404);
		
		
		
		
		
		
		
	}
	
	
	public Response GetMethodAll() {
		
		RestAssured.baseURI=BaseUri;
		RequestSpecification request=RestAssured.given();
		Response response=request.get();
		
		return response;
	}
	
	public Response PostMethod(String Name,String Salary) {
		
		RestAssured.baseURI = BaseUri;
		
		JSONObject jobj = new JSONObject();
		jobj.put("name", Name);
		jobj.put("salary", Salary);
		
		RequestSpecification request=RestAssured.given();
		Response resp =request.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(jobj.toString())
		.post("/create");
		
		return resp;
	}
	
	public Response PutMethod(int EmpId, String Name,String Salary) {
		
		RestAssured.baseURI = BaseUri;
		
		JSONObject jobj = new JSONObject();
		jobj.put("name", Name);
		jobj.put("salary", Salary);
		RequestSpecification request=RestAssured.given();
		Response response=request.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(jobj.toString())
		.put("" +EmpId);
		
		return response;
		
		
		
	}
	
	public Response DeleteMethod(int EmpID) {
		
		RestAssured.baseURI = BaseUri;
		RequestSpecification request=RestAssured.given();
		Response response=request.delete("" +EmpID);
		
		return response;
		
		
	}
	
	public Response GetEmployeeInfo(int Emp) {
		
		RestAssured.baseURI=BaseUri;
		RequestSpecification request=RestAssured.given();
		Response response=request.get(""+ Emp);
		return response;
		
		
		
	}
}
