package Adminmodel;
/*
 * ͼ��ʵ��
 */
public class Book {
private int novelid;//С˵���
private String novelname;//С˵����
private String novelmain;//С˵���
private String novelwriter;//С˵����
private Float novelmoney;//�۸�
private Integer classifyid;//С˵���id
private String classifyname;//С˵�������
private String novelpicture;//С˵ͼƬ


//����С˵���ƹ��췽��
public Book(String novelname) {
	super();
	this.novelname = novelname;
}

//Ĭ�Ϲ���
public Book() {
	super();
	// TODO Auto-generated constructor stub
}

//��ӹ��ܵĹ��췽��

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

//��ѯ���ܵĹ��췽��
public Book(String novelname, String novelwriter, Integer classifyid) {
	super();
	this.novelname = novelname;
	this.novelwriter = novelwriter;
	this.classifyid = classifyid;
}

//�޸Ĺ��ܵĹ��췽��

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
//��д���췽��
public String toString() {

		return novelname;

}
}
