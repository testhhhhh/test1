package Adminmodel;
//������������Ϊ������������Ҫ�̳нӿ�java.io.Serializable

public class Chapter {
private int chapterid;//�½�id
private Integer novelid;//С˵id
private String chaptername;//�½�����
private String chaptercontent;//�½�����


public Chapter() {
	super();
	// TODO Auto-generated constructor stub
}

//����½ڵĹ��췽��
public Chapter(Integer novelid, String chaptername, String chaptercontent) {
	super();
	this.novelid = novelid;
	this.chaptername = chaptername;
	this.chaptercontent = chaptercontent;
}

//��ѯ�½ڵĹ��췽��
public Chapter(Integer novelid, String chaptername) {
	super();
	this.novelid = novelid;
	this.chaptername = chaptername;
}

//�޸��½ڵĹ��췽��
public Chapter(int chapterid, Integer novelid, String chaptername, String chaptercontent) {
	super();
	this.chapterid = chapterid;
	this.novelid = novelid;
	this.chaptername = chaptername;
	this.chaptercontent = chaptercontent;
}


public int getChapterid() {
	return chapterid;
}






public void setChapterid(int chapterid) {
	this.chapterid = chapterid;
}


public Integer getNovelid() {
	return novelid;
}


public void setNovelid(Integer novelid) {
	this.novelid = novelid;
}


public String getChaptername() {
	return chaptername;
}


public void setChaptername(String chaptername) {
	this.chaptername = chaptername;
}


public String getChaptercontent() {
	return chaptercontent;
}


public void setChaptercontent(String chaptercontent) {
	this.chaptercontent = chaptercontent;
}



}
