package Adminmodel;

public class Transaction {
private int transactionid;//交易id
private Integer novelid;//小说id
private String novelname;//小说名称
private Integer userid;//用户id
private Float novelmoney;//小说价格
public int getTransactionid() {
	return transactionid;
}


public Transaction() {
	super();
	// TODO Auto-generated constructor stub
}


//查询小说名称的构造方法
public Transaction(Integer novelid) {
	super();
	this.novelid = novelid;
}


public void setTransactionid(int transactionid) {
	this.transactionid = transactionid;
}
public Integer getNovelid() {
	return novelid;
}
public void setNovelid(Integer novelid) {
	this.novelid = novelid;
}
public String getNovelname() {
	return novelname;
}
public void setNovelname(String novelname) {
	this.novelname = novelname;
}
public Integer getUserid() {
	return userid;
}
public void setUserid(Integer userid) {
	this.userid = userid;
}
public Float getNovelmoney() {
	return novelmoney;
}
public void setNovelmoney(Float novelmoney) {
	this.novelmoney = novelmoney;
}

}
