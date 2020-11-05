package UserPackage.src.Entity;


public class User {
	private String username;
    private String password;
    private String name;
    private String sex;
    private String telephone;
    private int code;
	public User() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public User(String username, String password, String name, String sex, String telephone,int code) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.telephone = telephone;
		this.code=code;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
    
}
