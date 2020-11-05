package UserPackage.src.Entity;
/*
 * 金额类
 */
public class Money {
private int moneyid;//金额id
private Integer userid;//用户id
private String username;//用户名
private Double money;//金额



public Money() {
	super();
	// TODO Auto-generated constructor stub
}

public int getMoneyid() {
	return moneyid;
}
//显示用户id和金额的构造方法

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
