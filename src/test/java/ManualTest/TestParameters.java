package ManualTest;

import java.sql.SQLException;

import InfrastructureLayer.BoardGameDAO;
import spark.Request;

public class TestParameters {
	public static void main(String[] args) {
		//Request req = null;
		//System.out.println(req.params(":jamel"));
		
		//Date date = 
		
		BoardGameDAO dao = new BoardGameDAO();
		
		/*
		try {
			System.out.println(dao.availableInRentBG(1));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		try {
			dao.increaseInRentBG(2);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
