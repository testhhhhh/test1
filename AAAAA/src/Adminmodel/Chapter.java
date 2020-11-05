package Adminmodel;
//以两个属性作为联合主键，需要继承接口java.io.Serializable

public class Chapter {
private int chapterid;//章节id
private Integer novelid;//小说id
private String chaptername;//章节名称
private String chaptercontent;//章节内容


public Chapter() {
	super();
	// TODO Auto-generated constructor stub
}

//添加章节的构造方法
public Chapter(Integer novelid, String chaptername, String chaptercontent) {
	super();
	this.novelid = novelid;
	this.chaptername = chaptername;
	this.chaptercontent = chaptercontent;
}

//查询章节的构造方法
public Chapter(Integer novelid, String chaptername) {
	super();
	this.novelid = novelid;
	this.chaptername = chaptername;
}

//修改章节的构造方法
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
