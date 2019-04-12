package InfrastructureLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	
}
