package entity;

public class User {
     private int userid;
     private String username;
     private String password;
     private String phone;
     private int rights;
     private String code;
     private String userintroduce;
	public User() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public User(int userid, String username, String password, String phone, int rights, String code,
			String userintroduce) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.rights = rights;
		this.code = code;
		this.userintroduce = userintroduce;
	}
	

	public User(int userid, String username, String phone, String userintroduce) {
		super();
		this.userid = userid;
		this.username = username;
		this.phone = phone;
		this.userintroduce = userintroduce;
	}
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public User(String username, String password, int rights) {
		super();
		this.username = username;
		this.password = password;
		this.rights = rights;
	}
	public User(String username,int rights) {
		super();
		this.username = username;
		this.rights = rights;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getRights() {
		return rights;
	}
	public void setRights(int rights) {
		this.rights = rights;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getUserintroduce() {
		return userintroduce;
	}
	public void setUserintroduce(String userintroduce) {
		this.userintroduce = userintroduce;
	}
     
}
