package Adminmodel;
/*
 * 小说类别实体
 */
public class BookType {
private int classifyid;//编号
private String classifyname;//图书类别名称

public BookType() {
	super();
	// TODO Auto-generated constructor stub
}

public BookType(String classifyname) {
	super();
	this.classifyname = classifyname;
}

public BookType(int classifyid, String classifyname) {
	super();
	this.classifyid = classifyid;
	this.classifyname = classifyname;
}

public int getClassifyid() {
	return classifyid;
}
public void setClassifyid(int classifyid) {
	this.classifyid = classifyid;
}
public String getClassifyname() {
	return classifyname;
}
public void setClassifyname(String classifyname) {
	this.classifyname = classifyname;
}
 
//重写方法，保证显示不是乱码
public String toString() {
	return classifyname;
}
}
