package Adminmodel;
/*
 * 管理员实体
 */
public class Admin {
private int userid;//编号
private String username;//用户名
private String password;//密码
private String state;
public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}

//生成构造方法
public Admin() {
	super();
	// TODO Auto-generated constructor stub
}



//判断是否为管理员的构造方法


public Admin(String username, String password, String state) {
	super();
	this.username = username;
	this.password = password;
	this.state = state;
}

//登录功能构造方法
public Admin(String username, String password) {
	super();
	this.username = username;
	this.password = password;
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

public String toString() {
	return state;
}
}
