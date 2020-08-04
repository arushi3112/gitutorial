package ApiTests.id;


import ApiTests.id.*;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class Test_Authenticate extends DataForTests{
	
	@BeforeClass
	public void setBaseUri()
	{
	baseURI="http://13.126.80.194:8080";
	}
	
	@Test(dataProvider = "DataForPost")
	public void verifyStatusCode(String username, String password)
	{


		int expectedStatusCode = 200; 
	    RequestSpecification request = RestAssured.given();
	    JSONObject requestParams = new JSONObject();
	    request.header("Content-Type", "application/json");
	    requestParams.put("password",password );
	    requestParams.put("username",username);
	    request.body(requestParams.toJSONString());
	    Response response = request.post("/authenticate");
	    System.out.println(requestParams.toJSONString());
	    int statusCode = response.getStatusCode();
	    System.out.println(statusCode);
	    Assert.assertEquals(statusCode , expectedStatusCode , "Correct status code was not returned");
	   
		
	}
	public void verifyReponse(String username, String password)
	{
		
		RequestSpecification request = RestAssured.given();
	    JSONObject requestParams = new JSONObject();
	    request.header("Content-Type", "application/json");
	    requestParams.put("password",password );
	    requestParams.put("username",username);
	    request.body(requestParams.toJSONString());
	    Response response = request.post("/authenticate");
	    System.out.println(requestParams.toJSONString());
	    
	    String responseBody = response.body().asString();
	    
	    Assert.assertNotNull(responseBody,"Null response received");
	    
	    
		
	}
	
	
	

}
