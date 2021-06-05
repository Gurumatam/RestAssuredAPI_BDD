package restAssuredTests;
import org.testng.annotations.Test;

import restAssuredBase.TestBase;

import static io.restassured.RestAssured.*;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;

public class Demo4_DELETE_Request extends TestBase {

	private static Logger logger = Logger.getLogger(Demo4_DELETE_Request.class);
	@Test
	public void deleteUser(Method method)
	{
		logger.info("Test " + method.getName()+" Started");
		given()
		.when()
		.delete("https://reqres.in/api/users/")
		.then()
		.statusCode(204);

		logger.info("Test " + method.getName()+" Passed");
	}
}
