package UserPackage.src.Entity;
/*
 * �����
 */
public class Money {
private int moneyid;//���id
private Integer userid;//�û�id
private String username;//�û���
private Double money;//���



public Money() {
	super();
	// TODO Auto-generated constructor stub
}

public int getMoneyid() {
	return moneyid;
}
//��ʾ�û�id�ͽ��Ĺ��췽��

public void setMoneyid(int moneyid) {
	this.moneyid = moneyid;
}
public Money(Integer userid, Double money) {
	super();
	this.userid = userid;
	this.money = money;
}
public Integer getUserid() {
	return userid;
}
public void setUserid(Integer userid) {
	this.userid = userid;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public Double getMoney() {
	return money;
}
public void setMoney(Double money) {
	this.money = money;
}

}
