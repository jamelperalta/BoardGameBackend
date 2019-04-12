package ManualTest;

import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import DomainLayer.User;
import DomainLayer.UserBoardGame;
import InfrastructureLayer.BoardGameDAO;
import InfrastructureLayer.MySQLConnect;
import InfrastructureLayer.UserDAO;

public class SideEffectFuncTest {

	public static void main(String[] args) {
		// Setting the DAO Component.
		BoardGameDAO dataAcessObject = new BoardGameDAO();
		String username = "";

		// Handling Error with try and catch
		try {

			// Getting the List generated from the DAO
			ArrayList<UserBoardGame> userBoardGames = dataAcessObject.getBoardgamesByUsername(username);

			// Converting from object to Json
			String jsonResult = convertToJSON(userBoardGames);

			if(jsonResult != null)
				System.out.println( jsonResult);
			else
				System.out.println( "{\"" + MySQLConnect.ERROR404 + "\":\"Error 404\"}");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			// Return the prototype error type
			System.out.println( "{\"" + MySQLConnect.ERROR500 + "\":\"Error 500\"}");
		}
	}

	/**
	 * For converting from object to JSON
	 */
	private static String convertToJSON(Object obj) {
		GsonBuilder jsonBuilder = new GsonBuilder();
		Gson jsonObj = jsonBuilder.create();
		return jsonObj.toJson(obj);
	}
	
	/**
	 * For converting from object to JSON
	 */
	private static String convertToJSON(ArrayList<Object> objs) {
		GsonBuilder jsonBuilder = new GsonBuilder();
		Gson jsonObj = jsonBuilder.create();
		return jsonObj.toJson(objs);
	}
}
