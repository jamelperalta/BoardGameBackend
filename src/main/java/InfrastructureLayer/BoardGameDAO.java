package InfrastructureLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DomainLayer.BoardGame;
import DomainLayer.Transaction;
import DomainLayer.User;
import DomainLayer.UserBoardGame;

/**
 * BoardGame DAO: The class that manages all sql queries
 * Things related to board games.
 * @author jamelperaltacoss, jorgecruz
 *
 */
public class BoardGameDAO {
	
	// Constructor
	public BoardGameDAO() {}
	
	//************** METHODS ******************
	
	/**
	 * This method is for gathering all the board game in sale.
	 * @return boardgames list of board games
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public ArrayList<BoardGame> getBoardgames() throws ClassNotFoundException, SQLException{
		// Setting the connection
		Connection con = MySQLConnect.getConnection(MySQLConnect.SERVER_IP_PORT, MySQLConnect.BG_SCHEMA,
				MySQLConnect.ROOTACCOUNT, MySQLConnect.ACCOUNTPASSWORD);

		// Query into the statement
		Statement stmt = con.createStatement();
		String query = "select title, description, publisher, average_playtime,"
				+ " max_player, photo_url, cat_name, cat_desc, bg_id from "
				+ "boardgame natural join bgcategory;";
		ResultSet rs = stmt.executeQuery(query);

		// Setting the result into Object.
		ArrayList<BoardGame> boardgames = new ArrayList<>();
		while(rs.next()) {
			String title = rs.getString(1);
			String description = rs.getString(2);
			String publisher = rs.getString(3);
			float avgPlaytime = rs.getFloat(4);
			int maxPlayer = rs.getInt(5);
			String url = rs.getString(6);
			String cat = rs.getString(7);
			String catDesc = rs.getString(8);
			int bg_id = rs.getInt(9);
			
			BoardGame boardgame = new BoardGame(title, description, url, cat, catDesc,
					0, publisher, avgPlaytime, maxPlayer, bg_id);
			boardgames.add(boardgame);
		}
		
		// Close the Connection
		con.close();
		
		// Return list of objects
		return boardgames;
	}
	
	/**
	 * This method is for gathering all the board game in sale.
	 * @return boardgames list of board games
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public ArrayList<BoardGame> getInSaleBoardgames() throws ClassNotFoundException, SQLException{
		// Setting the connection
		Connection con = MySQLConnect.getConnection(MySQLConnect.SERVER_IP_PORT, MySQLConnect.BG_SCHEMA,
				MySQLConnect.ROOTACCOUNT, MySQLConnect.ACCOUNTPASSWORD);

		// Query into the statement
		Statement stmt = con.createStatement();
		String query = "select title, description, publisher, average_playtime,"
				+ " max_player, quantity as sale_quantity, photo_url, cat_name, cat_desc, bg_id from "
				+ "sale_boardgames natural join boardgame natural join bgcategory;";
		ResultSet rs = stmt.executeQuery(query);

		// Setting the result into Object.
		ArrayList<BoardGame> inSaleBoardGames = new ArrayList<>();
		while(rs.next()) {
			String title = rs.getString(1);
			String description = rs.getString(2);
			String publisher = rs.getString(3);
			float avgPlaytime = rs.getFloat(4);
			int maxPlayer = rs.getInt(5);
			int saleQty = rs.getInt(6);
			String url = rs.getString(7);
			String cat = rs.getString(8);
			String catDesc = rs.getString(9);
			int bg_id = rs.getInt(10);
			
			BoardGame boardgame = new BoardGame(title, description, url, cat, catDesc,
					saleQty, publisher, avgPlaytime, maxPlayer, bg_id);
			inSaleBoardGames.add(boardgame);
		}
		
		// Close the Connection
		con.close();
		
		// Return list of objects
		return inSaleBoardGames;
	}
	
	/**
	 * This method is for gathering all info on a board game in sale.
	 * @return boardgames list of board games
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public BoardGame getInSaleBoardgame(int bg_id) throws ClassNotFoundException, SQLException{
		// Setting the connection
		Connection con = MySQLConnect.getConnection(MySQLConnect.SERVER_IP_PORT, MySQLConnect.BG_SCHEMA,
				MySQLConnect.ROOTACCOUNT, MySQLConnect.ACCOUNTPASSWORD);

		// Query into the statement
		Statement stmt = con.createStatement();
		String query = "select title, description, publisher, average_playtime,"
				+ " max_player, quantity as sale_quantity, photo_url, cat_name, cat_desc from "
				+ "sale_boardgames natural join boardgame natural join bgcategory "
				+ "where bg_id = " + bg_id + ";";
		ResultSet rs = stmt.executeQuery(query);

		// Setting the result into Object.
		BoardGame boardgame = null;
		while(rs.next()) {
			String title = rs.getString(1);
			String description = rs.getString(2);
			String publisher = rs.getString(3);
			float avgPlaytime = rs.getFloat(4);
			int maxPlayer = rs.getInt(5);
			int saleQty = rs.getInt(6);
			String url = rs.getString(7);
			String cat = rs.getString(8);
			String catDesc = rs.getString(9);
			
			boardgame = new BoardGame(title, description, url, cat, catDesc,
					saleQty, publisher, avgPlaytime, maxPlayer, bg_id);
		}
		
		// Close the Connection
		con.close();
		
		// Return list of objects
		return boardgame;
	}
	
	/**
	 * This method is for gathering all the board games in rent.
	 * @return boardgames list of boardgames
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public ArrayList<BoardGame> getInRentBoardgames() throws ClassNotFoundException, SQLException{
		// Setting the connection
		Connection con = MySQLConnect.getConnection(MySQLConnect.SERVER_IP_PORT, MySQLConnect.BG_SCHEMA,
				MySQLConnect.ROOTACCOUNT, MySQLConnect.ACCOUNTPASSWORD);

		// Query into the statement
		Statement stmt = con.createStatement();
		String query = "select title, description, publisher, average_playtime,"
				+ " max_player, quantity as sale_quantity, photo_url, cat_name, cat_desc, bg_id from "
				+ "rent_boardgames natural join boardgame natural join bgcategory;";
		ResultSet rs = stmt.executeQuery(query);

		// Setting the result into Object.
		ArrayList<BoardGame> inRentBoardGames = new ArrayList<>();
		while(rs.next()) {
			String title = rs.getString(1);
			String description = rs.getString(2);
			String publisher = rs.getString(3);
			float avgPlaytime = rs.getFloat(4);
			int maxPlayer = rs.getInt(5);
			int saleQty = rs.getInt(6);
			String url = rs.getString(7);
			String cat = rs.getString(8);
			String catDesc = rs.getString(9);
			int bg_id = rs.getInt(10);
			
			BoardGame boardgame = new BoardGame(title, description, url, cat, catDesc,
					saleQty, publisher, avgPlaytime, maxPlayer, bg_id);
			inRentBoardGames.add(boardgame);
		}

		// Close the Connection
		con.close();
		
		// Return list of objects
		return inRentBoardGames;
	}
	
	/**
	 * This method is for gathering all info on a board game in rent.
	 * @return boardgames list of board games
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public BoardGame getInRentBoardgame(int bg_id) throws ClassNotFoundException, SQLException{
		// Setting the connection
		Connection con = MySQLConnect.getConnection(MySQLConnect.SERVER_IP_PORT, MySQLConnect.BG_SCHEMA,
				MySQLConnect.ROOTACCOUNT, MySQLConnect.ACCOUNTPASSWORD);

		// Query into the statement
		Statement stmt = con.createStatement();
		String query = "select title, description, publisher, average_playtime,"
				+ " max_player, quantity as sale_quantity, photo_url, cat_name, cat_desc from "
				+ "rent_boardgames natural join boardgame natural join bgcategory "
				+ "where bg_id = " + bg_id + ";";
		ResultSet rs = stmt.executeQuery(query);

		// Setting the result into Object.
		BoardGame boardgame = null;
		while(rs.next()) {
			String title = rs.getString(1);
			String description = rs.getString(2);
			String publisher = rs.getString(3);
			float avgPlaytime = rs.getFloat(4);
			int maxPlayer = rs.getInt(5);
			int saleQty = rs.getInt(6);
			String url = rs.getString(7);
			String cat = rs.getString(8);
			String catDesc = rs.getString(9);
			
			boardgame = new BoardGame(title, description, url, cat, catDesc,
					saleQty, publisher, avgPlaytime, maxPlayer, bg_id);
		}
		
		// Close the Connection
		con.close();
		
		// Return list of objects
		return boardgame;
	}
	
	/**
	 * This method is for gathering all the board games for a particular username.
	 * @return userboardgames list of user board games
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public ArrayList<BoardGame> getBoardgamesByUsername(String username) throws ClassNotFoundException, SQLException{
		// Setting the connection
		Connection con = MySQLConnect.getConnection(MySQLConnect.SERVER_IP_PORT, MySQLConnect.BG_SCHEMA,
				MySQLConnect.ROOTACCOUNT, MySQLConnect.ACCOUNTPASSWORD);

		// Query into the statement
		Statement stmt = con.createStatement();
		String query = "select distinct title, description, publisher, average_playtime,"
				+ " max_player, photo_url, cat_name, cat_desc, bg_id "
				+ "from user natural join user_library natural join boardgame"
				+ " natural join bgcategory "
				+ "where username = '" + username + "';";
		ResultSet rs = stmt.executeQuery(query);

		// Setting the result into Object.
		ArrayList<BoardGame> userBoardGames = new ArrayList<>();
		while(rs.next()) {
			String title = rs.getString(1);
			String description = rs.getString(2);
			String publisher = rs.getString(3);
			float avgPlaytime = rs.getFloat(4);
			int maxPlayer = rs.getInt(5);
			String url = rs.getString(6);
			String cat = rs.getString(7);
			String catDesc = rs.getString(8);
			int bg_id = rs.getInt(9);
			
			BoardGame boardgame = new BoardGame(title, description, url, cat, catDesc,
					-1, publisher, avgPlaytime, maxPlayer, bg_id);
			userBoardGames.add(boardgame);
		}

		// Close the Connection
		con.close();
		
		// Return list of objects
		return userBoardGames;
	}

	/*
	 *  For buying a board game
	 */
	public Boolean buyBoardgame(String username, int bg_id, int quantity) throws ClassNotFoundException, SQLException {
		// Check if available
		if(!this.availableInSaleBG(bg_id))
			return false;

		// Get the user id in the table
		int u_id = this.getUserId(username);
		
		// Setting the connection
		Connection con = MySQLConnect.getConnection(MySQLConnect.SERVER_IP_PORT, MySQLConnect.BG_SCHEMA,
				MySQLConnect.ROOTACCOUNT, MySQLConnect.ACCOUNTPASSWORD);

		// Query for transaction
		String query = "insert into user_library(u_id, bg_id, quantity, transaction_type, transaction_date) \n" + 
				"values(" + u_id
				+ ", " + bg_id
				+ ", " + quantity
				+ ", 'owned', current_timestamp());";
		PreparedStatement insertQuery = con.prepareStatement(query);
		insertQuery.execute();
		
		return true;
	}
	
	public boolean availableInSaleBG(int bg_id) throws ClassNotFoundException, SQLException {
		// Values
		int quantity = 0;
		
		// Setting the connection
		Connection con = MySQLConnect.getConnection(MySQLConnect.SERVER_IP_PORT, MySQLConnect.BG_SCHEMA,
				MySQLConnect.ROOTACCOUNT, MySQLConnect.ACCOUNTPASSWORD);

		// Query into the statement
		Statement stmt = con.createStatement();
		String query = "SELECT title, quantity FROM sale_boardgames"
				+ " natural join boardgame where bg_id = " + bg_id + ";";
		ResultSet rs = stmt.executeQuery(query);

		// Setting the result into Object.
		while(rs.next()) {
			quantity = rs.getInt(2);
		}

		// Close the Connection
		con.close();
		
		// Qunatity must be greater than 0 in order to be available.
		if(quantity > 0)
			return true;
		
		return false;
	}
	
	/*
	 *  For renting a board game
	 */
	public Boolean rentBoardgame(String username, int bg_id, int quantity) throws ClassNotFoundException, SQLException {
		// Check if available
		if(!this.availableInRentBG(bg_id))
			return false;
		
		// Get the user id in the table
		int u_id = this.getUserId(username);
		
		// Setting the connection
		Connection con = MySQLConnect.getConnection(MySQLConnect.SERVER_IP_PORT, MySQLConnect.BG_SCHEMA,
				MySQLConnect.ROOTACCOUNT, MySQLConnect.ACCOUNTPASSWORD);

		// Query for transaction
		String query = "insert into user_library(u_id, bg_id, quantity, transaction_type, transaction_date) \n" + 
				"values(" + u_id
				+ ", " + bg_id
				+ ", " + quantity
				+ ", 'rented', current_timestamp());";
		PreparedStatement insertQuery = con.prepareStatement(query);
		insertQuery.execute();
		
		return true;
	}

	public boolean availableInRentBG(int bg_id) throws ClassNotFoundException, SQLException {
		// Values
		int quantity = 0;

		// Setting the connection
		Connection con = MySQLConnect.getConnection(MySQLConnect.SERVER_IP_PORT, MySQLConnect.BG_SCHEMA,
				MySQLConnect.ROOTACCOUNT, MySQLConnect.ACCOUNTPASSWORD);

		// Query into the statement
		Statement stmt = con.createStatement();
		String query = "SELECT title, quantity FROM rent_boardgames"
				+ " natural join boardgame where bg_id = " + bg_id + ";";
		ResultSet rs = stmt.executeQuery(query);

		// Setting the result into Object.
		while(rs.next()) {
			quantity = rs.getInt(2);
		}

		// Close the Connection
		con.close();

		// Qunatity must be greater than 0 in order to be available.
		if(quantity > 0)
			return true;

		return false;
	}
	
	/**
	 * This method is for gathering all the board games for a particular username.
	 * @return userboardgames list of user board games
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public ArrayList<UserBoardGame> getBoardgamesTransByUsername(String username) throws ClassNotFoundException, SQLException{
		// Setting the connection
		Connection con = MySQLConnect.getConnection(MySQLConnect.SERVER_IP_PORT, MySQLConnect.BG_SCHEMA,
				MySQLConnect.ROOTACCOUNT, MySQLConnect.ACCOUNTPASSWORD);

		// Query into the statement
		Statement stmt = con.createStatement();
		String query = "select title, description, publisher, average_playtime,"
				+ " max_player, photo_url, cat_name, cat_desc, quantity as qty_owned,"
				+ " transaction_type, transaction_date, username as owned_by, bg_id\n" + 
				"from user natural join user_library natural join boardgame"
				+ " natural join bgcategory\n" + 
				"where username = '" + username + "';";
		ResultSet rs = stmt.executeQuery(query);

		// Setting the result into Object.
		ArrayList<UserBoardGame> userBoardGames = new ArrayList<>();
		while(rs.next()) {
			String title = rs.getString(1);
			String description = rs.getString(2);
			String publisher = rs.getString(3);
			float avgPlaytime = rs.getFloat(4);
			int maxPlayer = rs.getInt(5);
			String url = rs.getString(6);
			String cat = rs.getString(7);
			String catDesc = rs.getString(8);
			int qty = rs.getInt(9);
			String trans_type = rs.getString(10);
			String trans_date = rs.getString(11);
			int bg_id = rs.getInt(13);
			
			UserBoardGame boardgame = new UserBoardGame(title, description, url, cat, catDesc,
					qty, publisher, avgPlaytime, maxPlayer, username, trans_type, trans_date, bg_id);
			userBoardGames.add(boardgame);
		}

		// Close the Connection
		con.close();
		
		// Return list of objects
		return userBoardGames;
	}
	
	/*
	 *  private function for looking for the user id.
	 */
	private int getUserId(String username) throws SQLException, ClassNotFoundException {
		// Setting the connection
		Connection con = MySQLConnect.getConnection(MySQLConnect.SERVER_IP_PORT, MySQLConnect.BG_SCHEMA,
				MySQLConnect.ROOTACCOUNT, MySQLConnect.ACCOUNTPASSWORD);

		// Query into the statement
		Statement stmt = con.createStatement();
		String query = "Select u_id from user where username = '" + username + "';";
		ResultSet rs = stmt.executeQuery(query);

		// Setting the result into Object.
		int u_id = -1;
		while(rs.next()) {
			u_id = rs.getInt(1);
		}

		// Close the Connection
		con.close();

		// Return list of objects
		return u_id;
	}
	
	
	
}
