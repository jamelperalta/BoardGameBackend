package ApplicationLayer;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.sql.SQLException;

import DomainLayer.Token;
import DomainLayer.User;
import InfrastructureLayer.MySQLConnect;
import InfrastructureLayer.UserDAO;
import InfrastructureLayer.Utilities;
import spark.Request;

/**
 * BoardGame Handler: The class that manages all the data structure and convert to json
 * Things related to users.
 * @author jamelperaltacoss, jorgecruz
 *
 */
public class UserHandler {
	
	// Constructor
	public UserHandler() {}
	
	// *********************** Methods ************************
	
	/*
	 * For getting all information on a certain username.
	 */
	public String getUserInfo(Request request) {
		
		UserDAO dataAcessObject = new UserDAO();
		
		// Get parameters
		String username = request.params(":username");

		// Handling Error with try and catch
		try {

			User userInfo = dataAcessObject.getUserInfo(username);

			String userInfoJSON = Utilities.convertToJSON(userInfo);
			return userInfoJSON;

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			// Return the prototype error type
			return "{\"" + MySQLConnect.ERROR500 + "\":\"Custom 500\"}";
		}
	}
	
	/*
	 * For loging into the api and getting a token
	 */
	public String login(Request request) {
		
		UserDAO dataAcessObject = new UserDAO();
		
		// Get parameters
		String username = request.params(":username");
		String password = request.params("password");
		
		// Handling Error with try and catch
		try {

			Token token = dataAcessObject.login(username, password);

			if (token == null)
				return "{\"" + MySQLConnect.ERROR404 + "\":\"Custom 404\"}";
			
			String tokenJSON = Utilities.convertToJSON(token);
			return tokenJSON;

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			// Return the prototype error type
			return "{\"" + MySQLConnect.ERROR500 + "\":\"Custom 500\"}";
		}
	}
	
	/*
	 * For checking whether the username provided exist or not
	 */
	public String availability(Request request) {
		
		UserDAO dataAcessObject = new UserDAO();

		// Get parameters
		String username = request.params(":username");

		// Handling Error with try and catch
		try {

			boolean available = dataAcessObject.availabilityUsername(username);

			String availability = "yes";
			if (!available)
				availability = "no";

			// Converting from object to Json
			String availabilityJSON = Utilities.convertToJSON(availability);
			return availabilityJSON;

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			// Return the prototype error type
			return "{\"" + MySQLConnect.ERROR500 + "\":\"Custom 500\"}";
		}
	}

	public String createAccount(Request request) {
		
		UserDAO dataAcessObject = new UserDAO();

		// Get parameters
		String name = request.params(":name");
		String username = request.params(":username");
		String email = request.params(":email");
		String password = request.params(":password");
		
		User user = new User(name, username, email);

		// Handling Error with try and catch
		try {

			boolean executed = dataAcessObject.createAccount(user, password);

			if(executed)
				return "Done";
			else
				return "{\"" + MySQLConnect.ERROR404 + "\":\"Error 404\"}";

		} catch (ClassNotFoundException | SQLException 
				| UnsupportedEncodingException | GeneralSecurityException e) {
			e.printStackTrace();
			// Return the prototype error type
			return "{\"" + MySQLConnect.ERROR500 + "\":\"Custom 500\"}";
		}


	}
	
	
	
	
	
	
}
