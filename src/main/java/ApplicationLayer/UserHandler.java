package ApplicationLayer;

import java.sql.SQLException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
		// Setting the DAO Component.
		UserDAO dataAcessObject = new UserDAO();
		
		// Get parameters
		String username = request.params(":username");

		// Handling Error with try and catch
		try {

			// Getting the List generated from the DAO
			User userInfo = dataAcessObject.getUserInfo(username);

			// Converting from object to Json
			String userInfoJSON = Utilities.convertToJSON(userInfo);
			return userInfoJSON;

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			// Return the prototype error type
			return "{\"" + MySQLConnect.ERROR500 + "\":\"Custom 500\"}";
		}
	}
	
}
