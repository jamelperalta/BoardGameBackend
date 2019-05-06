package ManualTest;
import static spark.Spark.*;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TestServer {
	
	public static void main(String[] args) {
		
		// The server ip is http://localhost:4567/

		path("/BGapi", () -> {

			path("/auth", () -> {

				get("/login/username/:username/password/:password", (request, response) -> {
					// Show something
					String output = "username: " + request.params(":username") 
					+ ", password: " + request.params(":password");
					return output;
				});

			});

			path("/apiV2", () -> {

				/**
				 *  ----------------------
				 *  
				 */
				
				before("/*", (request, response) -> {
					boolean authenticated = true;
					// ... check if authenticated
					String token = request.headers("Authentication");
					if (token == null)
						authenticated = false;

					if (!authenticated) {
						halt(401, "You are not welcome here");
					}
				});

				get("/get", (request, response) -> {
					// Show something
					return "Hello Get";
				});

				get("/get/json", (request, response) -> {
					// Show something

					// Building the JSON object
					GsonBuilder jsonBuilder = new GsonBuilder();

					// Instance of an object
					BGames game = new BGames("mate", "102", 50); 
					ArrayList<BGames> games = new ArrayList<>();
					games.add(new BGames("mate", "102", 50));
					games.add(new BGames("spanish", "105", 250));
					games.add(new BGames("english", "110", 150));

					// Converting object to JSON
					Gson jsonObj = jsonBuilder.create();

					return jsonObj.toJson(games);
				});

				post("/post", (request, response) -> {
					// Create something
					return "Hello Post";
				});

				put("/put", (request, response) -> {
					// Update something
					return "Hello put";
				});

				delete("/delete", (request, response) -> {
					// Annihilate something
					return "Hello Delete";
				});

				options("/options", (request, response) -> {
					// Appease something
					return "Hello options";
				});

			});

		});
		
		/**
		path("/BGapi", () -> {

			path("/auth", () -> {
				
			});

			path("/apiV2", () -> {
				
			});
			
		});
		*/
		
	}
	
	public static class BGames{
		//instance variables
		public String name;
		public String number;
		public int numberStudents;
		
		//constructor
		public BGames(String name, String number, int numberStudents) {
			this.name = name;
			this.number = number;
			this.numberStudents = numberStudents;
		}
	}
	
}
