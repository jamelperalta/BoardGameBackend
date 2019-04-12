package ManualTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DomainLayer.Transaction;
import InfrastructureLayer.MySQLConnect;

public class TestMySQL {
	
	public static void main(String[] args) {
		try {
			buyBoardgame();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void checkConnection() throws ClassNotFoundException, SQLException {
		// Setting the connection
		Connection con = MySQLConnect.getConnection(MySQLConnect.SERVER_IP_PORT, MySQLConnect.BG_SCHEMA,
				MySQLConnect.ROOTACCOUNT, MySQLConnect.ACCOUNTPASSWORD);
		
		// Query search
		Statement stmt = con.createStatement();
		String query = "select * from boardgame;";
		ResultSet rs = stmt.executeQuery(query);
		
		// Print data into display
		while(rs.next()) {
			String title = rs.getString(2);
			String desc = rs.getString(3);
			System.out.println("Title: " + title);
			System.out.println("Desc: " + desc);
		}
	}

	public static void buyBoardgame() throws ClassNotFoundException, SQLException {
		// Setting the connection
		Connection con = MySQLConnect.getConnection(MySQLConnect.SERVER_IP_PORT, MySQLConnect.BG_SCHEMA,
				MySQLConnect.ROOTACCOUNT, MySQLConnect.ACCOUNTPASSWORD);

		// Query for transaction
		String query = "insert into example(name, surname) values('jamel', 'peralta');";
		PreparedStatement insertQuery = con.prepareStatement(query);
		ResultSet executed = insertQuery.executeQuery();
		
		/**
		if(!executed) {
			ResultSet rs = insertQuery.getResultSet();
			
			System.out.println("it pass!");
			// Print data into display
			while(rs.next()) {
				String title = rs.getString(2);
				String desc = rs.getString(3);
				System.out.println("Title: " + title);
				System.out.println("Desc: " + desc);
			}
		}
		*/
		
	}
}
