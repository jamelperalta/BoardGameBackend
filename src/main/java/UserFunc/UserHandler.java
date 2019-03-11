package UserFunc;

import java.sql.SQLException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Entities.User;
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
		UserDAO dao = new UserDAO();
		
		// Get parameters
		String username = request.params(":username");

		// Handling Error with try and catch
		try {

			// Getting the List generated from the DAO
			User user = dao.getUserInfo(username);

			// Converting from object to Json
			GsonBuilder jsonBuilder = new GsonBuilder();
			Gson jsonObj = jsonBuilder.create();
			return jsonObj.toJson(user);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			// Return the prototype error type
			return "Error";
		}
	}
}
