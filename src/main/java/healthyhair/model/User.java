package healthyhair.model;

public class User {
	private String email;
	private String username;
	private String password;
	private String number;
	private String type;
	private int userId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public User(int userId) {
		this.userId = userId;
	}

	public User(String email, String username, String password, String type, String number) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.type = type;
		this.number = number;
	}

	public User(String email, String username, String password, String type, String number, int userId) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.type = type;
		this.number = number;
		this.userId = userId;
	}

	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
