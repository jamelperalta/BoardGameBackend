package BoardGameFunc;

import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Entities.BoardGame;

public class BoardgameHandler {
	
	// Constructor
	public BoardgameHandler() {}
	
	// *********************** Methods ************************
	
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
			return "Error";
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
			return "Error";
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
