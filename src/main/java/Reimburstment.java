
public class Reimburstment {
	private int Id;
	private  String Username;
	private  int Value;
	private String Type;
	private String Stat;
	
	public Reimburstment(int id, String username, int value, String type, String stat) {
		super();
		Id = id;
		Username = username;
		Value = value;
		Type = type;
		Stat = stat;
	}

	public Reimburstment() {
		// TODO Auto-generated constructor stub
	}
	
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getStat() {
		return Stat;
	}
	public void setStat(String stat) {
		Stat = stat;
	}
	public int getValue() {
		return Value;
	}
	public void setValue(int value) {
		Value = value;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	@Override
	public String toString() {
		return "Reimburstment [Id=" + Id + ", Username=" + Username + ", value=" + Value + "]";
	}
	
}
