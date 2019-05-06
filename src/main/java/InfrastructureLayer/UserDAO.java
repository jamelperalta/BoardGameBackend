package InfrastructureLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DomainLayer.Token;
import DomainLayer.User;

/**
 * BoardGame DAO: The class that manages all sql queries
 * Things related to users.
 * @author jamelperaltacoss, jorgecruz
 *
 */
public class UserDAO {
	
	// Constructor
	public UserDAO() {}
	
	//************** METHODS ******************
	
	/**
	 * This method is for gathering all information on certain username.
	 * @return user
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public User getUserInfo(String username) throws ClassNotFoundException, SQLException{
		// Setting the connection
		Connection con = MySQLConnect.getConnection(MySQLConnect.SERVER_IP_PORT, MySQLConnect.BG_SCHEMA,
				MySQLConnect.ROOTACCOUNT, MySQLConnect.ACCOUNTPASSWORD);

		// Query into the statement
		Statement stmt = con.createStatement();
		String query = "Select name, username, email from user where username = '" + username + "';";
		ResultSet rs = stmt.executeQuery(query);

		// Setting the result into Object.
		User user = null;
		while(rs.next()) {
			String name = rs.getString(1);
			String email = rs.getString(3);
			
			user = new User(name, username, email);
		}
		
		// Close the Connection
		con.close();
		
		// Return list of objects
		return user;
	}
	
	public Token login(String username, String password) throws ClassNotFoundException, SQLException {
		// Setting the connection
		Connection con = MySQLConnect.getConnection(MySQLConnect.SERVER_IP_PORT, MySQLConnect.BG_SCHEMA,
				MySQLConnect.ROOTACCOUNT, MySQLConnect.ACCOUNTPASSWORD);

		// Query into the statement
		Statement stmt = con.createStatement();
		String query = "Select username, hash_password from user "
				+ "natural join passwords where username = '" + username + "';";
		ResultSet rs = stmt.executeQuery(query);

		// Setting the result into Object.
		String correctPassword = null;
		while(rs.next()) {
			correctPassword = rs.getString(2);
		}
		
		// Close the Connection
		con.close();
		
		// Check if exist
		if (correctPassword != null) {
			// Show password
			System.out.println(correctPassword);
			
			// Check password
			if (Password.checkPassword(correctPassword, password))
				return Token.createToken(username);
			else
				System.out.println("Password is incorrect");
			
		}
		else
			System.out.println("username not existent");
			return null;

	}
	
	/**
	 * For testing purposes, in order to get generated Token for use of PostMan
	 * @param args
	 */
	public static void main(String[] args) {
		UserDAO dao = new UserDAO();
		try {
			Token token = dao.login("jamiboy", "jamiboy");
			System.out.println(token);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
