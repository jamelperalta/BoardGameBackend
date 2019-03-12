package Connectors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Jamel Peralta, Jorge Cruz
 * 
 *         MY SQL CONNECTION Class: A class for all the operations involving
 *         connecting to the server, and write and read from it.
 */
public class MySQLConnect {
	/**
	 * ----------------------------- SERVER INFORMATION  -----------------------------------------
	 */

	// Server Info
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String SERVER_IP_PORT = "localhost:3306";
	public static final String BG_SCHEMA = "BoardGameDB";
	
	// Server Account
	public static final String ROOTACCOUNT = "root";
	public static final String ACCOUNTPASSWORD = "root";

	/**
	 * ------------------------------- SERVER CONNECTION -----------------------------------------
	 */

	public static Connection getConnection(String serverIpPort, String plantSchema, String account, String pass)
			throws SQLException, ClassNotFoundException {
		Class.forName(DRIVER);
		String serverData = "jdbc:mysql://" + serverIpPort + "/" + plantSchema;
		return DriverManager.getConnection(serverData, account, pass);
	}
	
	/**
	 * ------------------------------- ERROR CODES MSG -----------------------------------------
	 */
	
	public static final String ERROR500 = "Internal Server Error: Ther server is turn off or the SQL Query is wrong";
	public static final String ERROR404 = "Not Found";
	public static final String ERROR400 = "Mal functioning query";
	
}
