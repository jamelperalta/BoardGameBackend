package TestingClasses;
import static spark.Spark.*;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TestServer {
	
	public static void main(String[] args) {
		
		// The server ip is http://localhost:4567/
		
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
