package Adminmodel;
/*
 * ����Աʵ��
 */
public class Admin {
private int userid;//���
private String username;//�û���
private String password;//����
private String state;
public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}

//���ɹ��췽��
public Admin() {
	super();
	// TODO Auto-generated constructor stub
}



//�ж��Ƿ�Ϊ����Ա�Ĺ��췽��


public Admin(String username, String password, String state) {
	super();
	this.username = username;
	this.password = password;
	this.state = state;
}

//��¼���ܹ��췽��
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
