package Entities;

/**
 * Entity: User
 * This have all the information related to the user.
 * @author jamelperaltacoss, jorgecruz
 *
 */
public class User {

	// Instance Variables
	public String name;
	public String username;
	public String email;
	
	// Constructor
	public User(String name, String username, String email) {
		this.name = name;
		this.username = username;
		this.email = email;
	}

	// Methods
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
