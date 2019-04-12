package DomainLayer;

/**
 * Entity: User
 * This have all the information related to the user.
 * @author jamelperaltacoss, jorgecruz
 *
 */
public class User {

	// Instance Variables
	private String name;
	private String username;
	private String email;
	
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
	
	/*
	 * Return true if and only if the parameter wallet contains exactly the same bills 
	 * as the target object.
	 */
	public boolean equals(Object o) {
		if (o instanceof User) {
			User usr = (User) o;
			return ((this.name     == usr.getName()) &&
					(this.username    == usr.getUsername()) &&
					(this.email     == usr.getEmail()));
		}
		return false;
	}
}
