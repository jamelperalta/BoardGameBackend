package BoardGameFunc;

import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Connectors.MySQLConnect;
import Entities.BoardGame;
import Entities.UserBoardGame;
import spark.Request;

/**
 * BoardGame Handler: The class that manages all the data structure and convert to json
 * Things related to board games.
 * @author jamelperaltacoss, jorgecruz
 *
 */
public class BoardgameHandler {
	
	// Constructor
	public BoardgameHandler() {}
	
	// *********************** Methods ************************
	
	/*
	 * For getting all the Board Games information.
	 */
	public String getBoardgames() {
		
		// Setting the DAO Component.
		BoardGameDAO dao = new BoardGameDAO();

		// Handling Error with try and catch
		try {
			
			// Getting the List generated from the DAO
			ArrayList<BoardGame> boardgames = dao.getBoardgames();
			
			// Converting from object to Json
			GsonBuilder jsonBuilder = new GsonBuilder();
			Gson jsonObj = jsonBuilder.create();
			return jsonObj.toJson(boardgames);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			// Return the prototype error type
			return "{\"" + MySQLConnect.ERROR500 + "\":\"Error 500\"}";
		}
	}
	
	/*
	 * For getting all the Board Games that are in sale.
	 */
	public String getInSaleBoardgames() {
		
		// Setting the DAO Component.
		BoardGameDAO dao = new BoardGameDAO();

		// Handling Error with try and catch
		try {
			
			// Getting the List generated from the DAO
			ArrayList<BoardGame> inSaleBoardGames = dao.getInSaleBoardgames();
			
			// Converting from object to Json
			GsonBuilder jsonBuilder = new GsonBuilder();
			Gson jsonObj = jsonBuilder.create();
			return jsonObj.toJson(inSaleBoardGames);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			// Return the prototype error type
			return "{\"" + MySQLConnect.ERROR500 + "\":\"Error 500\"}";
		}
	}
	
	/*
	 * For getting all the Board Games that are in rent.
	 */
	public String getInRentBoardgames() {

		// Setting the DAO Component.
		BoardGameDAO dao = new BoardGameDAO();

		// Handling Error with try and catch
		try {

			// Getting the List generated from the DAO
			ArrayList<BoardGame> inRentBoardGames = dao.getInRentBoardgames();

			// Converting from object to Json
			GsonBuilder jsonBuilder = new GsonBuilder();
			Gson jsonObj = jsonBuilder.create();
			return jsonObj.toJson(inRentBoardGames);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			// Return the prototype error type
			return "{\"" + MySQLConnect.ERROR500 + "\":\"Error 500\"}";
		}
	}
	
	/*
	 *  Forgetting the library of game owned by a username.
	 */
	public String getBoardgamesByUsername(Request request) {
		// Setting the DAO Component.
		BoardGameDAO dao = new BoardGameDAO();
		
		// Getting parameters
		String username = request.params(":username");

		// Handling Error with try and catch
		try {

			// Getting the List generated from the DAO
			ArrayList<UserBoardGame> userBoardGames = dao.getBoardgamesByUsername(username);

			// Converting from object to Json
			GsonBuilder jsonBuilder = new GsonBuilder();
			Gson jsonObj = jsonBuilder.create();
			String jsonResult = jsonObj.toJson(userBoardGames);
			
			if(jsonResult != null)
				return jsonResult;
			else
				return "{\"" + MySQLConnect.ERROR404 + "\":\"Error 404\"}";

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			// Return the prototype error type
			return "{\"" + MySQLConnect.ERROR500 + "\":\"Error 500\"}";
		}
	}

	/*
	 *  For buying a board game.
	 */
	public String buyBoardgame(Request request) {
		// Setting the DAO Component.
		BoardGameDAO dao = new BoardGameDAO();
		
		// Getting parameters
		String username = request.params(":username");
		int bg_id = Integer.parseInt(request.params(":bg_id"));
		int quantity = Integer.parseInt(request.params(":quantity"));

		// Handling Error with try and catch
		try {

			// Getting the List generated from the DAO
			Boolean executed = dao.buyBoardgame(username, bg_id, quantity);

			if(!executed)
				return "[done]";
			else
				return "{\"" + MySQLConnect.ERROR404 + "\":\"Error 404\"}";

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			// Return the prototype error type
			return "{\"" + "Transaction not made!" + "\":\"Error\"}";
		}
	}

	/*
	 *  For renting a board game.
	 */
	public String rentBoardgame(Request request) {
		// Setting the DAO Component.
		BoardGameDAO dao = new BoardGameDAO();
		
		// Getting parameters
		String username = request.params(":username");
		int bg_id = Integer.parseInt(request.params(":bg_id"));
		int quantity = Integer.parseInt(request.params(":quantity"));

		// Handling Error with try and catch
		try {

			// Getting the List generated from the DAO
			Boolean executed = dao.rentBoardgame(username, bg_id, quantity);

			if(!executed)
				return "[done]";
			else
				return "{\"" + MySQLConnect.ERROR404 + "\":\"Error 404\"}";

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			// Return the prototype error type
			return "{\"" + "Transaction not made!" + "\":\"Error\"}";
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	// Testing the class
	public static void main(String[] args) {
		
		BoardGameDAO dao = new BoardGameDAO();
		try {
			ArrayList<BoardGame> inSaleBoardGames = dao.getInSaleBoardgames();
			for(BoardGame game : inSaleBoardGames) {
				System.out.println(game);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
