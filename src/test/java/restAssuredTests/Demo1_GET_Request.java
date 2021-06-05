package restAssuredTests;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import restAssuredBase.TestBase;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.lang.reflect.Method;



public class Demo1_GET_Request extends TestBase{
	
	private static Logger logger = Logger.getLogger(Demo1_GET_Request.class);
		
	@ Test
	public void getUserDetails(Method method){
		
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		
		given()
		.when()
			.log().ifValidationFails()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.body("data[0].first_name", equalTo("Michael"))
			.header("Content-Type", containsString("application/json"));
		
	}
    
}
