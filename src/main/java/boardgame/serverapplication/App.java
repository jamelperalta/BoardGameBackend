package boardgame.serverapplication;

import static spark.Spark.*;

import ApplicationLayer.BoardgameHandler;
import ApplicationLayer.UserHandler;
import DomainLayer.Token;

/**
 * Main Class: The one that start the web application
 * and manages the routes to their respective handlers.
 * @author jamelperaltacoss, jorgecruz
 *
 */
public class App 
{
	public static void main( String[] args )
	{
		
		System.out.println("BOARDGAMES BACKEND SERVER APP: RUNNING");
		// The server IP is http://localhost:4567/

		// ********* MAIN PATH ************
		path("/BGapi", () -> {

			// AUTHENTICATION PATH
			path("/auth", () -> {

				// Route for getting board games in rent.
				get("/login/username/:username/password/:password", (request, response) -> {
					UserHandler userhandler = new UserHandler();
					return userhandler.login(request);
				});

				// Route for getting board games in rent.
				get("/availability/:username", (request, response) -> {
					UserHandler userhandler = new UserHandler();
					return userhandler.availability(request);
				});

				// Route for getting board games in rent.
				get("/logon/name/:name/username/:username/email/:email/password/:password",
						(request, response) -> {
							UserHandler userhandler = new UserHandler();
							return userhandler.createAccount(request);
						});

			});

			// API - PROTECTED PATH
			path("/apiV2", () -> {

				/**
				 * 	---------------------- AUTHENTICATION -----------------------------
				 */
				
				before("/*", (request, response) -> {
					
					// Get token from request header.
					String token = request.headers("Authentication");
					
					boolean authenticated = Token.verifyToken(token);

					if (!authenticated) {
						halt(401, "You are not welcome here");
					}
				});
				
				/**
				 *  ---------------------- BOARDGAMES ROUTES ---------------------------
				 */

				// Route for getting board games in sales.
				get("/getBoardGames", (request, response) -> {
					BoardgameHandler handler = new BoardgameHandler();
					return handler.getBoardgames();
				});

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

				// Route for getting board games owned by a user
				get("/getBoardGames/byusername/:username", (request, response) -> {
					BoardgameHandler handler = new BoardgameHandler();
					return handler.getBoardgamesByUsername(request);
				});

				// Route for getting board games owned by a user
				post("/buyBoardGames/byusername/:username/boardgameid/:bg_id/quantity/:quantity", (request, response) -> {
					BoardgameHandler handler = new BoardgameHandler();
					return handler.buyBoardgame(request);
				});

				// Route for getting board games owned by a user
				post("/rentBoardGames/byusername/:username/boardgameid/:bg_id/quantity/:quantity", (request, response) -> {
					BoardgameHandler handler = new BoardgameHandler();
					return handler.rentBoardgame(request);
				});

				/**
				 *  ---------------------- USER ROUTES ---------------------------
				 */

				// Route for getting board games in rent.
				get("/getUserInfo/:username", (request, response) -> {
					UserHandler userhandler = new UserHandler();
					return userhandler.getUserInfo(request);
				});

			});

		});



	}
}
