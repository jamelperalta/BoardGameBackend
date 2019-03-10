package BoardGameFunc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Connectors.MySQLConnect;
import Entities.BoardGame;

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
	public ArrayList<BoardGame> getInSaleBoardgames() throws ClassNotFoundException, SQLException{
		// Setting the connection
		Connection con = MySQLConnect.getConnection(MySQLConnect.SERVER_IP_PORT, MySQLConnect.BG_SCHEMA,
				MySQLConnect.ROOTACCOUNT, MySQLConnect.ACCOUNTPASSWORD);

		// Query into the statement
		Statement stmt = con.createStatement();
		String query = "select title, description, publisher, average_playtime,"
				+ " max_player, quantity as sale_quantity, photo_url, cat_name, cat_desc from "
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
			
			BoardGame boardgame = new BoardGame(title, description, url, cat, catDesc,
					saleQty, publisher, avgPlaytime, maxPlayer);
			inSaleBoardGames.add(boardgame);
		}
		
		// Close the Connection
		con.close();
		
		// Return list of objects
		return inSaleBoardGames;
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
				+ " max_player, quantity as sale_quantity, photo_url, cat_name, cat_desc from "
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
			
			BoardGame boardgame = new BoardGame(title, description, url, cat, catDesc,
					saleQty, publisher, avgPlaytime, maxPlayer);
			inRentBoardGames.add(boardgame);
		}

		// Close the Connection
		con.close();
		
		// Return list of objects
		return inRentBoardGames;
	}
	
	
	
	
	
	
	
	
	
	
}
