package models;

/**
 * Account object for the front controller
 * @author Jonathan
 *
 */
public class Account {
	
	private String username;
	private String password;
	
	public Account() {
	
	}

	/**
	 * @param username
	 * @param password
	 */
	public Account(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	
	/////getters and setters
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "\nAccount [username: " + username + "| password: " + password + "]";
	}

	
	
	
	
}

