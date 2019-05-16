package InfractructureLayer;

import static org.junit.jupiter.api.Assertions.*;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import DomainLayer.User;
import InfrastructureLayer.UserDAO;

/**
 * JUNIT for the class UserDAOTest.
 * @author jamelperaltacoss, jorgecruz
 *
 */
class UserDAOTest {

	/*
	 * This test class assumes that the following
	 * are free of defect:
	 * + deleteAccount
	 * 
	 */
	
	/* 
	 * A integration test for checking whether an account is created
	 * and verifying if exist in the database
	 */
	@Test
	void testCreateAccount() {
		
		// Data Object for unregister user
		User user = new User("Create AccountExample", "CreateAccount", "CreateAccount@upr.edu");
		
		// Prepare data
		UserDAO dao = new UserDAO();
		boolean exist = false;
		
		try {
			// Creating User in DB
			dao.createAccount(user, "CreateAccountPassword");
			
			// Boolean confirming if exist
			exist = !dao.availabilityUsername(user.getUsername());
			
			// Deleting account
			dao.deleteAccount(user.getUsername());
			
		} catch (ClassNotFoundException | UnsupportedEncodingException | SQLException | GeneralSecurityException e) {
			e.printStackTrace();
		}
		
		// Asserting that the create account works
		assertTrue(exist);
	}
	
	/*
	 * A integration test for checking whether an account is created
	 * and verifying if it deleted in the database
	 */
	@Test
	void testDeleteAccount() {
		
		// Data Object for unregister user
		User user = new User("Create AccountExample2", "CreateAccount2", "CreateAccount2@upr.edu");
		
		// Prepare data
		UserDAO dao = new UserDAO();
		boolean exist = false;
		
		try {
			// Creating User in DB
			dao.createAccount(user, "CreateAccountPassword2");
			
			// Deleting account
			dao.deleteAccount(user.getUsername());

			// Boolean confirming if exist
			exist = !dao.availabilityUsername(user.getUsername());
			
		} catch (ClassNotFoundException | UnsupportedEncodingException | SQLException | GeneralSecurityException e) {
			e.printStackTrace();
		}
		
		// Asserting that the create account works
		assertFalse(exist);
	}

}
