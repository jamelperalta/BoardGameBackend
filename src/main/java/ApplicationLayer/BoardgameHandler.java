package ApplicationLayer;

import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import DomainLayer.BoardGame;
import DomainLayer.UserBoardGame;
import InfrastructureLayer.BoardGameDAO;
import InfrastructureLayer.MySQLConnect;
import InfrastructureLayer.Utilities;
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
		BoardGameDAO dataAcessObject = new BoardGameDAO();

		// Handling Error with try and catch
		try {
			
			ArrayList<BoardGame> boardgames = dataAcessObject.getBoardgames();
			
			String boardgamesInfoJSON = Utilities.convertToJSON(boardgames);
			return boardgamesInfoJSON;

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
		BoardGameDAO dataAcessObject = new BoardGameDAO();

		// Handling Error with try and catch
		try {
			
			ArrayList<BoardGame> onSaleBoardGames = dataAcessObject.getInSaleBoardgames();
			
			String saleBoardgamesInfoJSON = Utilities.convertToJSON(onSaleBoardGames);
			return saleBoardgamesInfoJSON;

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
		BoardGameDAO dataAcessObject = new BoardGameDAO();

		// Handling Error with try and catch
		try {

			ArrayList<BoardGame> onRentBoardGames = dataAcessObject.getInRentBoardgames();

			String rentBoardgamesInfoJSON = Utilities.convertToJSON(onRentBoardGames);
			return rentBoardgamesInfoJSON;

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
		BoardGameDAO dataAcessObject = new BoardGameDAO();
		
		// Getting parameters
		String username = request.params(":username");

		// Handling Error with try and catch
		try {

			ArrayList<UserBoardGame> userBoardGames = dataAcessObject.getBoardgamesByUsername(username);

			String userLibraryInfoJSON = Utilities.convertToJSON(userBoardGames);
			
			if(userLibraryInfoJSON != null)
				return userLibraryInfoJSON;
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
		BoardGameDAO dataAcessObject = new BoardGameDAO();
		
		// Getting parameters
		String username = request.params(":username");
		int bg_id = Integer.parseInt(request.params(":bg_id"));
		int quantity = Integer.parseInt(request.params(":quantity"));

		// Handling Error with try and catch
		try {

			// Getting the List generated from the DAO
			Boolean executed = dataAcessObject.buyBoardgame(username, bg_id, quantity);

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
		BoardGameDAO dataAcessObject = new BoardGameDAO();
		
		// Getting parameters
		String username = request.params(":username");
		int bg_id = Integer.parseInt(request.params(":bg_id"));
		int quantity = Integer.parseInt(request.params(":quantity"));

		// Handling Error with try and catch
		try {

			// Getting the List generated from the DAO
			Boolean executed = dataAcessObject.rentBoardgame(username, bg_id, quantity);

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
	
	
	
	
	
	
	
	
	
}
