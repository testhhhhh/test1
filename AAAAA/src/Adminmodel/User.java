package Adminmodel;
/*
 * 用户实体
 */
public class User {
private int userid;
private String username;//用户名
private String password;//密码
private String name;//姓名
private String sex;//性别
private String telephone;//电话
private String state;//状态
private String code;
//默认构造
public User() {
	super();
	// TODO Auto-generated constructor stub
}

//添加数据的构造方法
public User(String username, String password, String name, String sex, String telephone, String state, String code) {
	super();
	this.username = username;
	this.password = password;
	this.name = name;
	this.sex = sex;
	this.telephone = telephone;
	this.state = state;
	this.code = code;
}



public int getUserid() {
	return userid;
}

//查询数据的构造方法
public User(String username, String name, String sex, String state) {
	super();
	this.username = username;
	this.name = name;
	this.sex = sex;
	this.state = state;
}


//修改数据的构造方法
public User(int userid, String username, String password, String name, String sex, String telephone, String state) {
	super();
	this.userid = userid;
	this.username = username;
	this.password = password;
	this.name = name;
	this.sex = sex;
	this.telephone = telephone;
	this.state = state;
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


public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}

public String getCode() {
	return code;
}

public void setCode(String code) {
	this.code = code;
}


}
