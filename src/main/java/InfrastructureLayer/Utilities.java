package InfrastructureLayer;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Utilities {
	/**
	 * For converting from object to JSON
	 */
	public static String convertToJSON(Object obj) {
		GsonBuilder jsonBuilder = new GsonBuilder();
		Gson jsonObj = jsonBuilder.create();
		return jsonObj.toJson(obj);
	}

	/**
	 * For converting from object to JSON
	 */
	public static String convertToJSON(ArrayList<Object> objs) {
		GsonBuilder jsonBuilder = new GsonBuilder();
		Gson jsonObj = jsonBuilder.create();
		return jsonObj.toJson(objs);
	}
}
