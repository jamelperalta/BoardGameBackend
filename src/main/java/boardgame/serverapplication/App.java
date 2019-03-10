package boardgame.serverapplication;

import static spark.Spark.*;

import BoardGameFunc.BoardgameHandler;

/**
 * Main Class: The one that start the web application
 * and maneges the routes to their respective handlers.
 * @author jamelperaltacoss, jorgecruz
 *
 */
public class App 
{
	public static void main( String[] args )
	{
		
		System.out.println("BOARDGAMES BACKEND SERVER APP: RUNNING");
		// The server ip is http://localhost:4567/

		/**
		 *  ---------------------- BOARDGAMES ROUTES ---------------------------
		 */
		
		// Route for getting board games in sales.
		get("/getBoardGames/InSale", (request, response) -> {
			BoardgameHandler handler = new BoardgameHandler();
			return handler.getInSaleBoardgames();
		});
		
		// Route for getting board games in rent.
		get("/getBoardGames/InRent", (request, response) -> {
			BoardgameHandler handler = new BoardgameHandler();
			return handler.getInRentBoardgames();
		});
		
		/**
		 *  ---------------------- USER ROUTES ---------------------------
		 */

		// Route for getting board games in rent.
		get("/getUserInfo", (request, response) -> {
			return "User Info";
		});

	}
}
