package UserFunc;

import org.junit.jupiter.api.Test;

import BoardGameFunc.BoardgameHandler;
import Connectors.MySQLConnect;
import junit.framework.TestCase;
import spark.Request;

/**
 * JUNIT for the class UserHandler.
 * @author jamelperaltacoss, jorgecruz
 *
 */
public class UserHandlerTest extends TestCase {
	
	/*
	 * This test class assumes that the following
	 * are free of defect:
	 * + MySQLConnect
	 * + Request
	 * 
	 */

	// If the request is empty, it should return a json error 404.
	@Test
	public void testEmptyRequestUser() {
		// Request is empty
		Request request = null;

		// Setting the class
		UserHandler handler = new UserHandler();
		String resultJSON = handler.getUserInfo(request);

		// Correct result of the JSON
		String correctJSON = "{\"" + MySQLConnect.ERROR404 + "\":\"Error 404\"}";

		// Assert that is true.
		assertTrue(resultJSON.equals(correctJSON));
	}

	// The username's library that you are looking in the db does not have any board games. Should return empty list.
	@Test
	public void testNotExistentUser() {
		// Request is empty
		Request request = (Request) new Object();
		request.attribute("username", "disparate");

		// Setting the class
		UserHandler handler = new UserHandler();
		String resultJSON = handler.getUserInfo(request);

		// Correct result of the JSON
		String correctJSON = "[]";

		// Assert that is true.
		assertTrue(resultJSON.equals(correctJSON));
	}
}
