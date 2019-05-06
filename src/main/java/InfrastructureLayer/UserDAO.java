package InfrastructureLayer;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DomainLayer.Authentication;
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
	
	/**
	 * This is for login
	 * @param username username that going to login
	 * @param password password in string
	 * @return token the token that the client app will need for api
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
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
	 * This check whether the username exist in the db or not.
	 * @param username
	 * @return exist
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean availabilityUsername(String username) throws ClassNotFoundException, SQLException {
		// Setting the connection
		Connection con = MySQLConnect.getConnection(MySQLConnect.SERVER_IP_PORT, MySQLConnect.BG_SCHEMA,
				MySQLConnect.ROOTACCOUNT, MySQLConnect.ACCOUNTPASSWORD);

		// Query into the statement
		Statement stmt = con.createStatement();
		String query = "Select username from user where username = '" + username + "';";
		ResultSet rs = stmt.executeQuery(query);

		// Setting the result into Object.
		String exist = null;
		while(rs.next()) {
			exist = rs.getString(1);
		}

		// Close the Connection
		con.close();
		
		if (exist == null)
			return true;
		return false;
	}

	/**
	 * Create Account with password.
	 * @param user
	 * @param password
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws UnsupportedEncodingException
	 * @throws GeneralSecurityException
	 */
	public boolean createAccount(User user, String password) throws ClassNotFoundException, SQLException,
	UnsupportedEncodingException, GeneralSecurityException {
		// Get the user id in the table
		boolean available = availabilityUsername(user.getUsername());

		if (available) {
			// Setting the connection
			Connection con = MySQLConnect.getConnection(MySQLConnect.SERVER_IP_PORT, MySQLConnect.BG_SCHEMA,
					MySQLConnect.ROOTACCOUNT, MySQLConnect.ACCOUNTPASSWORD);

			// Insert query for user table
			String query = "insert into user(name, username, email) \n" + 
					"values('" + user.getName()
					+ "', '" + user.getUsername()
					+ "', '" + user.getEmail()
					+ "');";
			PreparedStatement accountQuery = con.prepareStatement(query);
			accountQuery.execute();
			
			// Insert query for password table
			int u_id = this.getUserId(user.getUsername());
			String encryptedPass = Password.encrypt(password, Authentication.getSecretKeySpec());
			
			query = "insert into passwords(u_id, hash_password) \n" + 
					"values(" + u_id
					+ ", '" + encryptedPass
					+ "');";
			PreparedStatement passwordQuery = con.prepareStatement(query);
			passwordQuery.execute();
			
			// If the creation of the account is done and the password.
			return true;
		}
		
		return false;
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
