package ApiTests.id;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataForTests {
	
	
	@DataProvider(name="DataForPost")
	public Object[][] credentials()
	{
		
		Object[][] creds = new Object[1][2];
		
		creds[0][0] = "rupeek";
		creds[0][1] = "password";
		return creds;
		
	}
	


}
