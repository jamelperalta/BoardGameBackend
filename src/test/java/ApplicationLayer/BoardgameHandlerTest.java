package ApplicationLayer;

import org.junit.jupiter.api.Test;

import ApplicationLayer.BoardgameHandler;
import InfrastructureLayer.MySQLConnect;
import junit.framework.TestCase;
import spark.Request;

/**
 * JUNIT for the class BoardGameHandler.
 * @author jamelperaltacoss, jorgecruz
 *
 */
public class BoardgameHandlerTest extends TestCase {
	
	/*
	 * This test class assumes that the following
	 * are free of defect:
	 * + MySQLConnect
	 * + Request
	 * 
	 */
	
	// If the request is empty, it should return a json error 404.
	@Test
	public void testEmptyRequestUserBoardGames() {
		// Request is empty
		Request request = null;
		
		// Setting the class
		BoardgameHandler handler = new BoardgameHandler();
		String resultJSON = handler.getBoardgamesByUsername(request);
		
		// Correct result of the JSON
		String correctJSON = "{\"" + MySQLConnect.ERROR404 + "\":\"Error 404\"}";
		
		// Assert that is true.
		assertTrue(resultJSON.equals(correctJSON));
	}
	
	// The username's library that you are looking in the db does not have any board games. Should return empty list.
	@Test
	public void testEmptyLibraryUserBoardGames() {
		// Request is empty
		Request request = (Request) new Object();
		request.attribute("username", "disparate");

		// Setting the class
		BoardgameHandler handler = new BoardgameHandler();
		String resultJSON = handler.getBoardgamesByUsername(request);

		// Correct result of the JSON
		String correctJSON = "[]";

		// Assert that is true.
		assertTrue(resultJSON.equals(correctJSON));
	}

}
