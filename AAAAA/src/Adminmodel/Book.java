package Adminmodel;
/*
 * 图书实体
 */
public class Book {
private int novelid;//小说编号
private String novelname;//小说名称
private String novelmain;//小说简介
private String novelwriter;//小说作者
private Float novelmoney;//价格
private Integer classifyid;//小说类别id
private String classifyname;//小说类别名称
private String novelpicture;//小说图片


//搜索小说名称构造方法
public Book(String novelname) {
	super();
	this.novelname = novelname;
}

//默认构造
public Book() {
	super();
	// TODO Auto-generated constructor stub
}

//添加功能的构造方法

public Book(String novelname, String novelmain, String novelwriter, Float novelmoney, Integer classifyid,
		String novelpicture) {
	super();
	this.novelname = novelname;
	this.novelmain = novelmain;
	this.novelwriter = novelwriter;
	this.novelmoney = novelmoney;
	this.classifyid = classifyid;
	this.novelpicture = novelpicture;
}

//查询功能的构造方法
public Book(String novelname, String novelwriter, Integer classifyid) {
	super();
	this.novelname = novelname;
	this.novelwriter = novelwriter;
	this.classifyid = classifyid;
}

//修改功能的构造方法

public Book(int novelid, String novelname, String novelmain, String novelwriter, Float novelmoney, Integer classifyid,
		String novelpicture) {
	super();
	this.novelid = novelid;
	this.novelname = novelname;
	this.novelmain = novelmain;
	this.novelwriter = novelwriter;
	this.novelmoney = novelmoney;
	this.classifyid = classifyid;
	this.novelpicture = novelpicture;
}

public int getNovelid() {
	return novelid;
}


public void setNovelid(int novelid) {
	this.novelid = novelid;
}

public String getNovelname() {
	return novelname;
}

public void setNovelname(String novelname) {
	this.novelname = novelname;
}

public String getNovelmain() {
	return novelmain;
}

public void setNovelmain(String novelmain) {
	this.novelmain = novelmain;
}

public String getNovelwriter() {
	return novelwriter;
}

public void setNovelwriter(String novelwriter) {
	this.novelwriter = novelwriter;
}

public Float getNovelmoney() {
	return novelmoney;
}

public void setNovelmoney(Float novelmoney) {
	this.novelmoney = novelmoney;
}

public Integer getClassifyid() {
	return classifyid;
}

public void setClassifyid(Integer classifyid) {
	this.classifyid = classifyid;
}

public String getClassifyname() {
	return classifyname;
}

public void setClassifyname(String classifyname) {
	this.classifyname = classifyname;
}
public String getNovelpicture() {
	return novelpicture;
}

public void setNovelpicture(String novelpicture) {
	this.novelpicture = novelpicture;
}
//重写构造方法
public String toString() {

		return novelname;

}
}
