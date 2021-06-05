package restAssuredTests;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import restAssuredBase.TestBase;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.lang.reflect.Method;
import java.util.HashMap;

public class Demo2_POST_Request extends TestBase {

	private static Logger logger = Logger.getLogger(Demo2_POST_Request.class);
	public static HashMap dataMap = new HashMap();

	@BeforeMethod
	public void postData() {
		dataMap.put("name", "morpheus");
		dataMap.put("job", "leader");
		RestAssured.baseURI="https://reqres.in/api/users";
	}
	@Test
	public void createNewUser(Method method){
		logger.info("Test " + method.getName()+" Started");

		given()
		.contentType("application/json")
		.body (dataMap)

		.when()

		.post() //No need to provide URL as it is already defined as part of RestAssured.baseURI

		.then()
		.statusCode(201)
		.and()
		.body("name", equalTo("morpheus"))
		.and()
		.body("job", equalTo("leader"))
		.log().all();

	}
}
