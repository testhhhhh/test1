package Adminmodel;
/*
 * С˵���ʵ��
 */
public class BookType {
private int classifyid;//���
private String classifyname;//ͼ���������

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
 
//��д��������֤��ʾ��������
public String toString() {
	return classifyname;
}
}
