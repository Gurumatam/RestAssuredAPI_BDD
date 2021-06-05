package restAssuredTests;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import restAssuredBase.TestBase;

import static io.restassured.RestAssured.*;

import java.lang.reflect.Method;
import java.util.HashMap;

public class Demo3_PUT_Request extends TestBase{

	private static Logger logger = Logger.getLogger(Demo3_PUT_Request.class);
	public static HashMap dataMap = new HashMap();
	// https://reqres.in/api/users/2
	@BeforeMethod
	public void putData()
	{
		dataMap.put("name", "morpheus");
		dataMap.put("job", "zion resident");

		RestAssured.basePath = "https://reqres.in/api/users/2";
	}

	@Test
	public void updateUser(Method method){
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

		logger.info("Test " + method.getName()+" Started");

		given()
		.contentType("application/json")
		.body(dataMap)
		.when()
		.put()
		.then()
		.statusCode(200)
		.log().all();

	}

}
