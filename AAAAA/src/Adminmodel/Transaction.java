package Adminmodel;

public class Transaction {
private int transactionid;//����id
private Integer novelid;//С˵id
private String novelname;//С˵����
private Integer userid;//�û�id
private Float novelmoney;//С˵�۸�
public int getTransactionid() {
	return transactionid;
}


public Transaction() {
	super();
	// TODO Auto-generated constructor stub
}


//��ѯС˵���ƵĹ��췽��
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
