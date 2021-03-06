package ApplicationLayer;

import java.sql.SQLException;
import java.util.ArrayList;

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

	public String modifyBoardGameByid(Request request) {
		
		BoardGameDAO dataAcessObject = new BoardGameDAO();

		// Getting parameters
		int bg_id = Integer.parseInt(request.params(":bg_id"));
		String desc = request.params(":desc");
		String publisher = request.params(":publisher");
		float avg_time = Float.parseFloat(request.params(":avg_time"));
		int max_player = Integer.parseInt(request.params(":max_player"));

		// Handling Error with try and catch
		try {

			Boolean executed = dataAcessObject.modifyBoardGameByid(bg_id, desc, publisher, avg_time, max_player);

			if(executed)
				return "Done";
			else
				return "{\"" + MySQLConnect.ERROR404 + "\":\"Modification not made!\"}";

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			// Return the prototype error type
			return "{\"" + "SQL Error" + "\":\"Error\"}";
		}
	}

	/*
	 * For getting all the Board Games that are in sale.
	 */
	public String getInSaleBoardgames() {
		
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
	 * For getting all info on a Board Games that is in sale.
	 */
	public String getInSaleBoardgame(Request request) {
		
		BoardGameDAO dataAcessObject = new BoardGameDAO();

		// Getting parameters
		int bg_id = Integer.parseInt(request.params(":bg_id"));

		// Handling Error with try and catch
		try {
			
			BoardGame onSaleBoardGame = dataAcessObject.getInSaleBoardgame(bg_id);
			
			String saleBoardgamesInfoJSON = Utilities.convertToJSON(onSaleBoardGame);
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
	 * For getting all info on a Board Games that is in sale.
	 */
	public String getInRentBoardgame(Request request) {
		
		BoardGameDAO dataAcessObject = new BoardGameDAO();

		// Getting parameters
		int bg_id = Integer.parseInt(request.params(":bg_id"));

		// Handling Error with try and catch
		try {
			
			BoardGame onSaleBoardGame = dataAcessObject.getInRentBoardgame(bg_id);
			
			String saleBoardgamesInfoJSON = Utilities.convertToJSON(onSaleBoardGame);
			return saleBoardgamesInfoJSON;

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			// Return the prototype error type
			return "{\"" + MySQLConnect.ERROR500 + "\":\"Error 500\"}";
		}
	}
	
	/*
	 *  For getting the library of game owned by a username.
	 */
	public String getBoardgamesByUsername(Request request) {
		
		BoardGameDAO dataAcessObject = new BoardGameDAO();
		
		// Getting parameters
		String username = request.params(":username");

		// Handling Error with try and catch
		try {

			ArrayList<BoardGame> userBoardGames = dataAcessObject.getBoardgamesByUsername(username);

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
	 *  For getting the transaction of game owned by a username.
	 */
	public String getBoardgamesTransByUsername(Request request) {
		
		BoardGameDAO dataAcessObject = new BoardGameDAO();
		
		// Getting parameters
		String username = request.params(":username");

		// Handling Error with try and catch
		try {

			ArrayList<UserBoardGame> userBoardGames = dataAcessObject.getBoardgamesTransByUsername(username);

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
		
		BoardGameDAO dataAcessObject = new BoardGameDAO();
		
		// Getting parameters
		String username = request.params(":username");
		int bg_id = Integer.parseInt(request.params(":bg_id"));
		int quantity = Integer.parseInt(request.params(":quantity"));

		// Handling Error with try and catch
		try {

			// Getting the List generated from the DAO
			Boolean executed = dataAcessObject.buyBoardgame(username, bg_id, quantity);

			if(executed)
				return "Done";
			else
				return "{\"" + MySQLConnect.ERROR404 + "\":\"Not Found or unavailable resource.\"}";

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
		
		BoardGameDAO dataAcessObject = new BoardGameDAO();
		
		// Getting parameters
		String username = request.params(":username");
		int bg_id = Integer.parseInt(request.params(":bg_id"));
		int quantity = Integer.parseInt(request.params(":quantity"));

		// Handling Error with try and catch
		try {

			// Getting the List generated from the DAO
			Boolean executed = dataAcessObject.rentBoardgame(username, bg_id, quantity);

			if(executed)
				return "Done";
			else
				return "{\"" + MySQLConnect.ERROR404 + "\":\"Not Found or unavailable resource.\"}";

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			// Return the prototype error type
			return "{\"" + "Transaction not made!" + "\":\"Error\"}";
		}
	}
	

	
	
	
	
}
