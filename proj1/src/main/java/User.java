
public class User {
	private int Id;
	private  String Username;
	private  String Password;
	private int Authority;
	private String name;
	private String email;
	private String phone;
	public String getPassword() {
		return Password;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	public User(int id, String username, String password, int authority, String name, String email, String phone) {
		Id = id;
		Username = username;
		Password = password;
		Authority = authority;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	public User() {
		}
	
	public void setPassword(String password) {
		Password = password;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	
	@Override
	public String toString() {
		return "User [Id=" + Id + ", Username=" + Username + ", Password=" + Password + ", Authority=" + Authority
				+ "]";
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getAuthority() {
		return Authority;
	}
	public void setAuthority(int authorithy) {
		Authority = authorithy;
	}
}
